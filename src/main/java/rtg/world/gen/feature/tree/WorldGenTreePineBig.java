package rtg.world.gen.feature.tree;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTreePineBig extends WorldGenerator
{
	private int startHeight;
	private int treeSize;
	
	private int metadataLog;
	private int metadataLeaves;
	
	public WorldGenTreePineBig(int start, int s)
	{
		this(start, s, 0, 0);
	}
	
	public WorldGenTreePineBig(int start, int s, int log, int leaves)
	{
		startHeight = start;
		treeSize = s;
		metadataLog = log;
		metadataLeaves = leaves;
	}
	
    public boolean generate(World world, Random rand, BlockPos pos)
    {
    	int startY = pos.getY();
    	
    	Block g = world.getBlockState(pos.down()).getBlock();
    	if(g != Blocks.grass && g != Blocks.dirt)
    	{
    		return false;
    	}
    	
    	buildTrunk(world, rand, pos.east());
    	buildTrunk(world, rand, pos.west());
    	buildTrunk(world, rand, pos.north());
    	buildTrunk(world, rand, pos.south());
    	
    	int i;
    	for(i = 0; i < startHeight; i++)
    	{
    		world.setBlockState(pos, Blocks.log.getStateFromMeta(metadataLog), 0);
    		if(i > 5 && rand.nextInt(7) == 0)
    		{
    			int dX = -1 + rand.nextInt(3);
    			int dZ = -1 + rand.nextInt(3);
    			
    			if(dX == 0 && dZ == 0)
    			{
    				dX = -1 + rand.nextInt(3);
    				dZ = -1 + rand.nextInt(3);
    			}
    			
    			buildBranch(world, rand, pos, dX, dZ, 1, 1);
    		}
    		
    		pos = pos.up();
    	}
    	
    	int pX = 0;
    	int pZ = 0;
    	int j;
    	for(i = 0; i < treeSize; i++)
    	{
    		if(rand.nextInt(i < treeSize - 12 && i > 2 ? 2 : 1) == 0 && i < treeSize - 2)
    		{
    			int dX = -1 + rand.nextInt(3);
    			int dZ = -1 + rand.nextInt(3);
    			
    			if(dX == 0 && dZ == 0)
    			{
    				dX = -1 + rand.nextInt(3);
    				dZ = -1 + rand.nextInt(3);
    			}
    			
    			if(pX == dX && rand.nextBoolean())
    			{
    				dX = -dX;
    			}
    			if(pZ == dZ && rand.nextBoolean())
    			{
    				dZ = -dZ;
    			}
    			
    			pX = dX;
    			pZ = dZ;

        		buildBranch(world, rand, pos, dX, dZ, 
        			i < treeSize - 12 && i > 3 ? 3 : i < treeSize - 8 ? 2 : 1, 
        			i < treeSize - 5 ? 2 : 1
        		);
    		}
    		world.setBlockState(pos, Blocks.log.getStateFromMeta(metadataLog), 0);
    		
    		if(i < treeSize - 2)
	    	{
	    		if(rand.nextBoolean()) { buildLeaves(world, pos.north()); }
	    		if(rand.nextBoolean()) { buildLeaves(world, pos.south()); }
	    		if(rand.nextBoolean()) { buildLeaves(world, pos.east()); }
	    		if(rand.nextBoolean()) { buildLeaves(world, pos.west()); }
    		}
    		
    		pos = pos.up();
    	}
    	
    	buildLeaves(world, pos.add(0, -1, 1));
    	buildLeaves(world, pos.add(0, -1, -1));
    	buildLeaves(world, pos.add(1, -1, 0));
    	buildLeaves(world, pos.add(-1, -1, 0));
    	buildLeaves(world, pos);
    	
    	return true;
    }
    
    public void buildBranch(World world, Random rand, BlockPos pos, int dX, int dZ, int logLength, int leaveSize)
    {
    	if(logLength == 3 && Math.abs(dX) + Math.abs(dZ) == 2)
    	{
    		logLength--;
    	}
    	
    	for(int i = -1; i <= 1; i++)
    	{
    		for(int j = -1; j <= 1; j++)
    		{
    			for(int k = 0; k < 2; k++)
    			{
    				if(Math.abs(i) + Math.abs(j) + Math.abs(k) < leaveSize + 1)
    				{
        				buildLeaves(world, pos.add(i + (dX * logLength), k, j + (dZ * logLength)));
    				}
    			}
    		}
    	}
    	
    	for(int m = 1; m <= logLength; m++)
    	{
        	world.setBlockState(pos.add((dX * m), 0, (dZ * m)), Blocks.log.getStateFromMeta(metadataLog), 0);
    	}
    }
    
    public void buildLeaves(World world, BlockPos pos)
    {
    	Block b = world.getBlockState(pos).getBlock();
    	if(b.getMaterial() == Material.air)
    	{
    		world.setBlockState(pos, Blocks.leaves.getStateFromMeta(metadataLeaves), 0);
    	}
    }
    
    public void buildTrunk(World world, Random rand, BlockPos pos)
    {
    	int h = (int)Math.ceil(startHeight / 4f);
    	h = h + rand.nextInt(h * 2);
    	for(int i = -1; i < h; i++)
    	{
    		world.setBlockState(pos.up(i), Blocks.log.getStateFromMeta(metadataLog + 12), 0);
    	}
    }
}
