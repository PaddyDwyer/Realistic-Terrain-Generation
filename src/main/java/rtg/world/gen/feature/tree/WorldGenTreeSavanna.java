package rtg.world.gen.feature.tree;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTreeSavanna extends WorldGenerator
{
	private int type;
	private boolean sand;
	
    public WorldGenTreeSavanna(int t)
    {
    	this(t, true);
    }
    
    public WorldGenTreeSavanna(int t, boolean s)
    {
    	type = t;
    	sand = s;
    }

    public boolean generate(World world, Random rand, BlockPos pos)
    {
    	Block b = world.getBlockState(pos.down()).getBlock();
    	if(b != Blocks.grass && b != Blocks.dirt && ((sand && b != Blocks.sand) || !sand))
    	{
    		return false;
    	}
    	
    	if(type == 0)
    	{
	    	int h = 10 + rand.nextInt(5);
	    	int bh = h - 6;
	    	
	    	for(int i = 0; i < h; i++)
	    	{
	    		world.setBlockState(pos.up(i), Blocks.log2.getDefaultState(), 0);
	    	}
			genLeaves(world, rand, pos.up(h));
			
			int sh, eh, dir;
			float xd, yd, c;
			
			for(int a = 7 - 1 + rand.nextInt(3); a > -1; a--)
			{
				sh = bh + rand.nextInt(6 - 2);
				eh = h - (int)((h - sh) * 1f);
				dir = rand.nextInt(360);
				xd = (float)Math.cos(dir * Math.PI / 180f) * 2f;
				yd = (float)Math.sin(dir * Math.PI / 180f) * 2f;
				c = 1;
				
				BlockPos pos1 = pos.add(xd * c, sh, yd * c);
				
				while(sh < h)
				{
					world.setBlockState(pos1, Blocks.log2.getDefaultState(), 0);
					sh++;
					c += 0.5f;
					pos1 = pos.add(xd * c, sh, yd * c);
				}
				genLeaves(world, rand, pos1);
			}
    	}
    	else if(type == 1)
    	{
	    	int h = 6 + rand.nextInt(3);
	    	int bh = h - 3;
	    	
	    	for(int i = 0; i < h; i++)
	    	{
	    		world.setBlockState(pos.up(i), Blocks.log2.getDefaultState(), 0);
	    	}
			genLeaves(world, rand, pos.up(h));
			
			int sh, eh, dir;
			float xd, yd, c;
			
			for(int a = 1 + rand.nextInt(2); a > -1; a--)
			{
				sh = bh + rand.nextInt(3 - 1);
				eh = h - (int)((h - sh) * 0.25f);
				dir = rand.nextInt(360);
				xd = (float)Math.cos(dir * Math.PI / 180f) * 2f;
				yd = (float)Math.sin(dir * Math.PI / 180f) * 2f;
				c = 1;
				
				BlockPos pos1 = pos.add(xd * c, sh, yd * c);
				
				while(sh < h)
				{
					world.setBlockState(pos1, Blocks.log2.getDefaultState(), 0);
					sh++;
					c += 0.5f;
					pos1 = pos.add(xd * c, sh, yd * c);
				}
				genLeaves(world, rand, pos1);
			}
    	}
    	else if(type == 2)
    	{
	    	int h = 12 + rand.nextInt(5);
	    	int bh = h - 3;
	    	
	    	for(int i = 0; i < h; i++)
	    	{
	    		world.setBlockState(pos.up(i), Blocks.log2.getDefaultState());
	    	}
			genLeaves(world, rand, pos.up(h));
			
			int sh, eh, dir;
			float xd, yd, c;
			
			for(int a = 1 + rand.nextInt(2); a > -1; a--)
			{
				sh = bh + rand.nextInt(3 - 1);
				eh = h - (int)((h - sh) * 0.25f);
				dir = rand.nextInt(360);
				xd = (float)Math.cos(dir * Math.PI / 180f) * 2f;
				yd = (float)Math.sin(dir * Math.PI / 180f) * 2f;
				c = 1;
				
				BlockPos pos1 = pos.add(xd * c, sh, yd * c);
				
				while(sh < h)
				{
					world.setBlockState(pos1, Blocks.log2.getDefaultState());
					sh++;
					c += 0.5f;
					pos1 = pos.add(xd * c, sh, yd * c);
				}
				genLeaves(world, rand, pos1);
			}
    	}
    	
    	return true;
    }
    
    public void genLeaves(World world, Random rand, BlockPos pos)
    {
    	if(type == 0)
    	{
	    	int i;
	    	int j;
	    	for(i = -2; i <= 2; i++)
	    	{
	    		for(j = -2; j <= 2; j++)
	    		{
	    			BlockPos pos1 = pos.add(i, 1, j);
	    			if(world.isAirBlock(pos1) && Math.abs(i) + Math.abs(j) < 4)
	    			{
	    				world.setBlockState(pos1, Blocks.leaves2.getDefaultState(), 0);
	    			}
	    		}
	    	}
	    	
	    	for(i = -3; i <= 3; i++)
	    	{
	    		for(j = -3; j <= 3; j++)
	    		{
	    			BlockPos pos1 = pos.add(i, 0, j);
	    			if(world.isAirBlock(pos1) && Math.abs(i) + Math.abs(j) < 5)
	    			{
	    				world.setBlockState(pos1, Blocks.leaves2.getDefaultState(), 0);
	    			}
	    		}
	    	}
	    	
	    	world.setBlockState(pos, Blocks.log2.getDefaultState());
    	}
    	else
    	{
	    	int i;
	    	int j;
	    	for(i = -1; i <= 1; i++)
	    	{
	    		for(j = -1; j <= 1; j++)
	    		{
	    			BlockPos pos1 = pos.add(i, 1, j);
	    			if(world.isAirBlock(pos1))
	    			{
	    				world.setBlockState(pos1, Blocks.leaves2.getDefaultState(), 0);
	    			}
	    		}
	    	}
	    	
	    	for(i = -2; i <= 2; i++)
	    	{
	    		for(j = -2; j <= 2; j++)
	    		{
	    			BlockPos pos1 = pos.add(i, 0, j);
	    			if(world.isAirBlock(pos1) && Math.abs(i) + Math.abs(j) < 4)
	    			{
	    				world.setBlockState(pos1, Blocks.leaves2.getDefaultState(), 0);
	    			}
	    		}
	    	}
	    	
	    	world.setBlockState(pos, Blocks.log2.getDefaultState());
    	}
    }
}
