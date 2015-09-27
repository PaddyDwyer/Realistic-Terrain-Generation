package rtg.world.gen.feature.tree;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTreeSpruceSmall extends WorldGenerator
{
	private int treeSize;
	
	public WorldGenTreeSpruceSmall(int s)
	{
		treeSize = s;
	}

    public boolean generate(World world, Random rand, BlockPos pos)
    {
    	Block g = world.getBlockState(pos.down()).getBlock();
    	if(g != Blocks.grass && g != Blocks.dirt)
    	{
    		return false;
    	}
    	
    	int leavesMeta = rand.nextInt(2);
    	
    	int start = 1;
    	int small = 2;
    	int large = 0;
    	if(treeSize == 1)
    	{
    		small = 2;
    		large = 2;
    	}
    	else if(treeSize == 2)
    	{
        	start = 1 + rand.nextInt(2);
    		small = 3;
    		large = 3;
    	}
    	
    	int i, j, k;
    	for(i = 0; i < start; i++)
    	{
    		world.setBlockState(pos, Blocks.log.getDefaultState(), 0);
    		pos = pos.up();
    	}

    	for(i = 0; i < large; i++)
    	{
    		for(j = -2; j <= 2; j++)
    		{
    			for(k = -2; k <= 2; k++)
    			{
    				if(Math.abs(j) + Math.abs(k) != 4 && ((j > -2 && k > -2 && j < 2 && k < 2) || rand.nextInt(4) != 0))
    				{
    					world.setBlockState(pos.add(j, 0, k), Blocks.leaves.getStateFromMeta(leavesMeta), 0);
    				}
    			}
    		}
    		world.setBlockState(pos, Blocks.log.getDefaultState(), 0);
    		pos = pos.up();
    	}
    	
    	for(i = 0; i < small; i++)
    	{
    		for(j = -1; j <= 1; j++)
    		{
    			for(k = -1; k <= 1; k++)
    			{
    				if(Math.abs(j) + Math.abs(k) < 2 || (rand.nextInt(4) != 0))
    				{
    					world.setBlockState(pos.add(j, 0, k), Blocks.leaves.getStateFromMeta(leavesMeta), 0);
    				}
    			}
    		}
    		
    		if(i == 0)
    		{
    	    	world.setBlockState(pos.east(), Blocks.leaves.getStateFromMeta(leavesMeta), 0);
    	    	world.setBlockState(pos.west(), Blocks.leaves.getStateFromMeta(leavesMeta), 0);
    	    	world.setBlockState(pos.south(), Blocks.leaves.getStateFromMeta(leavesMeta), 0);
    	    	world.setBlockState(pos.north(), Blocks.leaves.getStateFromMeta(leavesMeta), 0);
    	    	world.setBlockState(pos.east(2), Blocks.leaves.getStateFromMeta(leavesMeta), 0);
    	    	world.setBlockState(pos.west(2), Blocks.leaves.getStateFromMeta(leavesMeta), 0);
    	    	world.setBlockState(pos.south(2), Blocks.leaves.getStateFromMeta(leavesMeta), 0);
    	    	world.setBlockState(pos.north(2), Blocks.leaves.getStateFromMeta(leavesMeta), 0);
    		}
    		
    		world.setBlockState(pos, Blocks.log.getDefaultState(), 0);
    		pos = pos.up();
    	}
    	
		world.setBlockState(pos, Blocks.log.getDefaultState(), 0);
    	world.setBlockState(pos.east(), Blocks.leaves.getStateFromMeta(leavesMeta), 0);
    	world.setBlockState(pos.west(), Blocks.leaves.getStateFromMeta(leavesMeta), 0);
    	world.setBlockState(pos.south(), Blocks.leaves.getStateFromMeta(leavesMeta), 0);
    	world.setBlockState(pos.north(), Blocks.leaves.getStateFromMeta(leavesMeta), 0);
    	
    	world.setBlockState(pos.up(), Blocks.leaves.getStateFromMeta(leavesMeta), 0);
    	world.setBlockState(pos.up(2), Blocks.leaves.getStateFromMeta(leavesMeta), 0);
		return true;
	}
}
