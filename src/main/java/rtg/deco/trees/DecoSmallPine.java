package rtg.deco.trees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DecoSmallPine extends WorldGenerator
{
	private int startHeight;
	private int treeSize;
	private int metadata;
	
	public DecoSmallPine(int start, int s)
	{
		this(start, s, 1);
	}
	
	public DecoSmallPine(int start, int s, int m)
	{
		startHeight = start;
		treeSize = s;
		metadata = m;
	}
	
    public boolean generate(World world, Random rand, BlockPos pos)
    {
    	Block g = world.getBlockState(pos.down()).getBlock();
    	if(g != Blocks.grass && g != Blocks.dirt)
    	{
    		return false;
    	}
    	
    	int i;
    	for(i = 0; i < startHeight; i++)
    	{
    		world.setBlockState(pos, Blocks.log.getStateFromMeta(metadata), 0);
    		pos = pos.up();
    	}
    	
    	int pX = 0;
    	int pZ = 0;
    	for(i = 0; i < treeSize; i++)
    	{
    		if(rand.nextInt(1) == 0 && i < treeSize - 2)
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

        		buildBranch(world, rand, pos, dX, dZ, i < treeSize - 10 ? 2 : 1, i < treeSize - 6 ? 2 : 1);
    		}
    		world.setBlockState(pos, Blocks.log.getStateFromMeta(metadata), 0);
    		
    		if(i < treeSize - 2)
	    	{
	    		if(rand.nextBoolean()) { buildLeaves(world, pos.south()); }
	    		if(rand.nextBoolean()) { buildLeaves(world, pos.north()); }
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
    	for(int i = -1; i <= 1; i++)
    	{
    		for(int j = -1; j <= 1; j++)
    		{
    			for(int k = 0; k < 2; k++)
    			{
    				if(Math.abs(i) + Math.abs(j) + Math.abs(k) < leaveSize + 1)
    				{
        				buildLeaves(world, pos.add(i+ (dX * logLength), k, j + (dZ * logLength)));
    				}
    			}
    		}
    	}
    	
    	for(int m = 1; m <= logLength; m++)
    	{
        	world.setBlockState(pos.add((dX * m), 0, (dZ * m)), Blocks.log.getStateFromMeta(metadata), 0);
    	}
    }
    
    public void buildLeaves(World world, BlockPos pos)
    {
    	Block b = world.getBlockState(pos).getBlock();
    	if(b.getMaterial() == Material.air)
    	{
    		world.setBlockState(pos, Blocks.leaves.getStateFromMeta(metadata), 0);
    	}
    }
}
