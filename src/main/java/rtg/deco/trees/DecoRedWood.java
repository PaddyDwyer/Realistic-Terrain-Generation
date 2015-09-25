package rtg.deco.trees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DecoRedWood extends WorldGenerator
{
	private int height;
	private int leaves;
	private int trunk;
	private int metadata;
	
	public DecoRedWood(int h, int l, int t, int m)
	{
		height = h;
		leaves = l;
		trunk = t;
		metadata = m;
	}

    public boolean generate(World world, Random rand, BlockPos pos)
    {
    	Block g = world.getBlockState(pos.down()).getBlock();
    	if(g != Blocks.grass && g != Blocks.dirt && g != Blocks.sand)
    	{
    		return false;
    	}
    	
    	for(int l1 = 0; l1 < 5; l1++)
    	{
			genLeaves(world, rand, pos.add(-1 + rand.nextInt(3), height - l1, -1 + rand.nextInt(3)), 1);
			genLeaves(world, rand, pos.add(-1 + rand.nextInt(3), height - l1, -1 + rand.nextInt(3)), 1);
    	}
    	for(int l2 = 5; l2 < leaves; l2++)
    	{
			genLeaves(world, rand, pos.add(-2 + rand.nextInt(5), height - l2, -2 + rand.nextInt(5)), 2);
			if(rand.nextBoolean())
			{
				genLeaves(world, rand, pos.add(-2 + rand.nextInt(5), height - l2, -2 + rand.nextInt(5)), 2);
			}
    	}
    	
    	for(int i = 0; i < height; i++)
    	{
        	world.setBlockState(pos.up(i), Blocks.log.getDefaultState(), 0);
    	}
    	world.setBlockState(pos.up(height), Blocks.leaves.getStateFromMeta(metadata), 0);
    	createTrunk(world, rand, pos);
    	
    	return true;
    }

    public void genLeaves(World world, Random rand, BlockPos pos, int size)
    {
    	int i;
    	int j;
    	int dis;
    	for(i = -1; i <= 1; i++)
    	{
    		for(j = -1; j <= 1; j++)
    		{
    			dis = Math.abs(i) + Math.abs(j);
    			BlockPos pos1 = pos.add(i, 1 ,j);
    			if(world.isAirBlock(pos1) && (dis < size - 1 || (dis < size && rand.nextBoolean())))
    			{
    				world.setBlockState(pos1, Blocks.leaves.getStateFromMeta(metadata), 0);
    			}
    		}
    	}
    	
    	for(i = -2; i <= 2; i++)
    	{
    		for(j = -2; j <= 2; j++)
    		{
    			dis = Math.abs(i) + Math.abs(j);
    			BlockPos pos1 = pos.add(i, 0 ,j);
    			if(world.isAirBlock(pos1) && (dis < size * 2 - 1 || (dis < size * 2 && rand.nextBoolean())))
    			{
    				world.setBlockState(pos1, Blocks.leaves.getStateFromMeta(metadata), 0);
    			}
    		}
    	}
    	
    	if(size > 1)
    	{
    		world.setBlockState(pos, Blocks.log.getStateFromMeta(12), 0);
    	}
    }
    
    private void createTrunk(World world, Random rand, BlockPos pos)
    {
    	int[] vec = new int[]{0,0, 1,0, 0,1, -1,0, 0,-1, 1,1, 1,-1, -1,1, -1,-1};
    	BlockPos pos1;
    	Block b;
    	for(int t = 0; t < 9; t++)
    	{    	
    		pos1 = pos.up(vec[t*2] == 0 || vec[t*2+1] == 0 ? rand.nextInt(trunk * 2) + trunk : rand.nextInt(trunk) - 1);
    		while(pos1.getY() > pos.getY() - 2)
    		{
    			BlockPos pos2 = pos.add(vec[t * 2], 0, vec[t * 2 + 1]);
    			if(world.getBlockState(pos2).getBlock() == Blocks.grass)
    			{
    				break;
    			}
    			world.setBlockState(pos2, Blocks.log.getStateFromMeta(12), 0);
    			pos1 = pos.down();
    		}
    	}
    }
}
