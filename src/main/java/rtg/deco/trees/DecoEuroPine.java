package rtg.deco.trees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DecoEuroPine extends WorldGenerator
{
	public DecoEuroPine()
	{
	}

    public boolean generate(World world, Random rand, BlockPos pos)
    {
    	Block g = world.getBlockState(pos.down()).getBlock();
    	if(g != Blocks.grass && g != Blocks.dirt)
    	{
    		return false;
    	}
    	
    	int height = 18 + rand.nextInt(10);
    	int leafheight = 7 + rand.nextInt(4);
    	float branchIncrease = 0.25f;
    	
    	for(int i = 0; i <= height; i++)
    	{
    		world.setBlockState(pos.up(i), Blocks.log.getDefaultState(), 0);
    	}
    	createRandomLeaves(world, rand, pos.up(height), 2);
    	createTrunk(world, rand, pos);
    	
    	int dir = 0, b;
    	float xd, yd, bl = 1f;
    	for(int j = height; j >= height - leafheight; j--)
    	{
    		bl += branchIncrease;
    		dir += rand.nextInt(180) + 90;
    		dir -= dir > 360 ? 360 : 0;
			xd = (float)Math.cos(dir * Math.PI / 180f);
			yd = (float)Math.sin(dir * Math.PI / 180f);
			
			for(b = 0; b <= bl; b++)
			{
				world.setBlockState(pos.add((b * xd), j, (b * yd)), Blocks.log.getStateFromMeta(12), 0);
			}
	    	createRandomLeaves(world, rand, pos.up(j), 2);
	    	createRandomLeaves(world, rand, pos.add((b * xd), j, (b * yd)), 2);
    	}
    	
    	return true;
    }
    
    private void createRandomLeaves(World world, Random rand, BlockPos pos, int size)
    {
    	int l;
    	int t = (int)Math.pow(size, 2);
    	for(int i = -size; i <= size; i++)
    	{
    		for(int j = -size; j <= size; j++)
    		{
    			for(int k = -size; k <= size; k++)
    			{
    				l = i*i + j*j + k*k;
    				if(l <= t)
    				{
    					BlockPos pos1 = pos.add(i, j, k);
    					if(world.isAirBlock(pos1) && (l < t / 2 || rand.nextBoolean()))
    					{
    						world.setBlockState(pos1, Blocks.leaves.getStateFromMeta(4), 0);
    					}
    				}
    			}
    		}
    	}
    }
    
    private void createTrunk(World world, Random rand, BlockPos pos)
    {
    	// TODO Rename vec
    	int[] vec = new int[]{0,0, 1,0, 0,1, -1,0, 0,-1};
    	BlockPos pos1;
    	for(int t = 0; t < 5; t++)
    	{    	
    		pos1 = pos.up(rand.nextInt(3));
    		while(pos1.getY() > pos.getY() - 3)
    		{
    			BlockPos pos2 = pos1.add(vec[t * 2], 0, vec[t * 2 + 1]);
    			if(world.getBlockState(pos2).getBlock() == Blocks.dirt)
    			{
    				break;
    			}
    			world.setBlockState(pos2, Blocks.log.getStateFromMeta(12), 0);
    			pos1 = pos.down();
    		}
    	}
    }
}
