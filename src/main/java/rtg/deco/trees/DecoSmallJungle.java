package rtg.deco.trees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DecoSmallJungle extends WorldGenerator
{
	public DecoSmallJungle()
	{
	}

	@Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
		int size = 3;
		
    	Block b = world.getBlockState(pos.down()).getBlock();
    	if(b != Blocks.grass && b != Blocks.dirt && b != Blocks.sand)
    	{
    		return false;
    	}
    	
    	Material m = world.getBlockState(pos).getBlock().getMaterial();
    	if(m != Material.air && m != Material.vine)
    	{
    		return false;
    	}
    	
    	int i = 0, j, dx, dz, l, s, h = (size * 2) + rand.nextInt(size);
    	for(; i < h; i++)
    	{
    		world.setBlockState(pos.up(i), Blocks.log.getStateFromMeta(3), 0);
    	}
    	buildLeaves(world, rand, pos.up(h -1));
    	
    	if(size > 1)
    	{
	    	for(i = 0; i < size + 1; i++)
	    	{
	    		dx = rand.nextInt(3) - 1;
	    		dz = rand.nextInt(3) - 1;
	    		if(dx == 0 && dz == 0)
	    		{
	        		dx = rand.nextInt(3) - 1;
	        		dz = rand.nextInt(3) - 1;
	    		}
	    		
	    		l = (size - 1) + (Math.abs(dx) + Math.abs(dz) == 1 ? rand.nextInt(size - 1) : 0);
	    		
	    		s = h - size - rand.nextInt(size);
	    		for(j = 1; j <= l; j++)
	    		{
	    			world.setBlockState(pos.add(dx * j,	s + j, dz * j), Blocks.log.getStateFromMeta(3), 0);
	    		}
	    		j--;
	    		buildLeaves(world, rand, pos.add(dx * j,	s + j, dz * j));
	    	}
    	}
    	
		return true;
    }
	
	private void buildLeaves(World w, Random rand, BlockPos pos)
	{
		int i, j;
		for(i = -1; i <= 1; i++)
		{
			for(j = -1; j <= 1; j++)
			{
				buildBlock(w, pos.add(i, 0, j), Blocks.leaves, 3, 0);
			}
		}
		
		for(i = -1; i < 2; i+=2)
		{
			buildBlock(w, pos.add(1, i, 0), Blocks.leaves, 3, 0);
			buildBlock(w, pos.add(-1, i, 0), Blocks.leaves, 3, 0);
			buildBlock(w, pos.add(0, i, 1), Blocks.leaves, 3, 0);
			buildBlock(w, pos.add(0, i, -1), Blocks.leaves, 3, 0);
			buildBlock(w, pos.add(0, i, 0), Blocks.leaves, 3, 0);
		}
	}
	
	private void buildBlock(World w, BlockPos pos, Block b, int m, int u)
	{
		Material ma = w.getBlockState(pos).getBlock().getMaterial();
		
		if(ma == Material.air || ma == Material.vine)
		{
			w.setBlockState(pos, b.getStateFromMeta(m), u);
		}
	}
}
