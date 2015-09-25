package rtg.deco.trees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DecoDeadDesertTrees extends WorldGenerator
{
	private int type;
	
    public DecoDeadDesertTrees(int t)
    {
    	type = t;
    }

    public boolean generate(World world, Random rand, BlockPos pos)
    {
    	Block g = world.getBlockState(pos.down()).getBlock();
    	if(g != Blocks.grass && g != Blocks.dirt && g != Blocks.sand)
    	{
    		return false;
    	}
    	
    	if(type == 0)
    	{
    		int i, h = 8;
    		
    		for(i = 0; i < h; i++)
    		{
    			world.setBlockState(pos.up(i), Blocks.log2.getStateFromMeta(0), 0);
    		}
    		
    		int branches = 2 + rand.nextInt(3);
    		float dir, xd, yd, zd, l, c, sk = (360f / branches);
    		
    		for(i = 0; i < branches; i++)
    		{
    			dir = i * sk + rand.nextFloat() * sk;
				xd = (float)Math.cos(dir * Math.PI / 180f);
				zd = (float)Math.sin(dir * Math.PI / 180f);
				l = 1f + rand.nextFloat() * 3f;
				c = 1f;
				
				while(c < l)
				{
					world.setBlockState(pos.add(xd * c, h + c, zd * c), Blocks.log2.getStateFromMeta(12), 0);
					c += 1f;
				}
    		}
    	}
    	else
    	{
    		int h = rand.nextInt(3) + 2;
	    	for(int i = 0; i < h; i++)
	    	{
	    		world.setBlockState(pos.up(i), Blocks.log2.getStateFromMeta(0), 0);
	    	}
	    	
	    	h--;
	    	world.setBlockState(pos.add(1, h, 0), Blocks.leaves2.getDefaultState(), 0);
	    	world.setBlockState(pos.add(-1, h, 0), Blocks.leaves2.getDefaultState(), 0);
	    	world.setBlockState(pos.add(0, h, 1), Blocks.leaves2.getDefaultState(), 0);
	    	world.setBlockState(pos.add(0, h, -1), Blocks.leaves2.getDefaultState(), 0);
	    	world.setBlockState(pos.add(0, h+1, 0), Blocks.leaves2.getDefaultState(), 0);
    	}
    	
    	return true;
    }
}
