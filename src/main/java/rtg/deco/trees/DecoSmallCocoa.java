package rtg.deco.trees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DecoSmallCocoa extends WorldGenerator
{
	private static int[] cocoas = new int[]{
		2, 0, -2, 1,
		1, 1, -2, 0,
		0, 0, -2, -1,
		3, -1, -2, 0
	};
	
	public DecoSmallCocoa()
	{
		
	}

	@Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
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
    	
    	int h = pos.getY() + 2 + rand.nextInt(3);
    	for(; pos.getY() < h; pos = pos.up())
    	{
    		world.setBlockState(pos, Blocks.log.getStateFromMeta(3), 0);
    	}
    	
    	for(int i = -2; i <= 2; i++)
    	{
        	for(int j = -2; j <= 2; j++)
        	{
        		if(Math.abs(i) + Math.abs(j) < 3)
        		{
        			buildBlock(world, pos.add(i, -1, j), Blocks.leaves, 3, 0);
        		}
        	}
    	}

		world.setBlockState(pos.down(), Blocks.log.getStateFromMeta(3), 0);
		buildBlock(world, pos.east(), Blocks.leaves, 3, 0);
		buildBlock(world, pos.west(), Blocks.leaves, 3, 0);
		buildBlock(world, pos, Blocks.leaves, 3, 0);
		buildBlock(world, pos.north(), Blocks.leaves, 3, 0);
		buildBlock(world, pos.south(), Blocks.leaves, 3, 0);
    	
    	for(int k = 0; k < 16; k+=4)
    	{
    		if(rand.nextInt(20) == 0)
    		{
    			buildBlock(world, pos.add(cocoas[k + 1], cocoas[k + 2], cocoas[k + 3]), Blocks.cocoa, cocoas[k + 0] + 8, 0);
    		}
    	}
    	
		return true;
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
