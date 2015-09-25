package rtg.deco.ruins;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class DecoRuinsAncient 
{
	private Block block;
	
	public DecoRuinsAncient(Block b)
	{
		block = b;
	}
	
	public boolean generate(World world, Random rand, BlockPos pos) 
	{
		int type = rand.nextInt(2);
		
		Block g = world.getBlockState(pos.down()).getBlock();
    	if(g.getMaterial() != Material.ground && g.getMaterial() != Material.grass && g.getMaterial() != Material.sand && g.getMaterial() != Material.rock)
    	{
    		return false;
    	}
    	
    	int high = pos.getY();
    	int low = pos.getY();
    	for(int cX = -6; cX <= 6; cX += 12)
    	{
    		for(int cZ = -6; cZ <= 6; cZ += 12)
    		{
    			for(int cY = 10; cY > 40; cY--)
    			{
					Block b = world.getBlockState(pos.add(cX, cY, cZ)).getBlock();
			    	if(b.getMaterial() == Material.ground || b.getMaterial() == Material.grass || b.getMaterial() == Material.sand || b.getMaterial() == Material.rock)
			    	{
			    		high = cY > high ? cY : high;
			    		low = cY < low ? cY : low;
			    		
			    		break;
			    	}
    			}
    		}
    	}
    	
    	if(high - low > 6)
    	{
    		return false;
    	}
		
		if(type == 0) //pillars
		{
			for(int a = rand.nextInt(4) + 3; a > -1; a--)
			{
				BlockPos pos1 = pos.add(-4 + rand.nextInt(9), 10, -4 + rand.nextInt(9));
				
				for(int sY = pos1.getY(); sY > 50; sY--)
				{
					Block b = world.getBlockState(pos1.down()).getBlock();
			    	if(b.getMaterial() == Material.ground || b.getMaterial() == Material.grass || b.getMaterial() == Material.sand || b.getMaterial() == Material.rock)
			    	{
			    		break;
			    	}
				}
				
				int h = rand.nextInt(3) + 2 - rand.nextInt(2);
				for(int i = 0; i < h; i++)
				{
					world.setBlockState(pos1.up(i), block.getDefaultState(), 0);
				}
			}
		}
		else if(type == 1) //big pillar
		{
			for(int i = -1; i <= 1; i++)
			{
				for(int j = -1; j <= 1; j++)
				{
					int h = rand.nextInt(4) + (i == 0 && j == 0 ? 3 : 1);
					for(int k = -2; k < h; k++)
					{
						world.setBlockState(pos.add(i, k, j), block.getDefaultState(), 0);
					}
				}
			}
		}
		
		return true;
	}
}
