package rtg.world.gen.feature.tree;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTreeShrub extends WorldGenerator
{
	private int size;
	private Block logBlock;
	private int logMeta;
	private Block leaveBlock;
	private int leaveMeta;
	private boolean sand;

	public WorldGenTreeShrub(int s, int log, int leav)
	{
		this(s, log, leav, false);
	}
	
	public WorldGenTreeShrub(int s, int log, int leav, boolean sa)
	{
		size = s;
		sand = sa;

		logBlock = log < 3 ? Blocks.log : Blocks.log2;
		logMeta = log > 2 ? log - 3 : log;
		
		leaveBlock = leav < 4 ? Blocks.leaves : Blocks.leaves2;
		leaveMeta = leav > 3 ? leav - 4 : leav;
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) 
	{
		int width = size > 6 ? 6 : size;
		int height = size > 3 ? 2 : 1;
		
		for(int i = 0; i < size; i++)
		{
			int rX = rand.nextInt(width * 2) - width;
			int rY = rand.nextInt(height);
			int rZ = rand.nextInt(width * 2) - width;
			
			if(i == 0 && size > 4)
			{
				buildLeaves(world, pos.add(rX, 0, rZ), 3);
			}
			else if(i == 1 && size > 2)
			{
				buildLeaves(world, pos.add(rX, 0, rZ), 2);
			}
			else
			{
				buildLeaves(world, pos.add(rX, rY, rZ), 1);
			}
		}
		return true;
	}
	
	public void buildLeaves(World world, BlockPos pos, int size)
	{
		Block b = world.getBlockState(pos.down(2)).getBlock();
		if(b.getMaterial() == Material.grass || b.getMaterial() == Material.ground || (sand && b.getMaterial() == Material.sand))
		{
			if(world.getBlockState(pos.down()).getBlock() != Blocks.water )
			{
				for(int i = -size; i <= size; i++)
				{
					for(int j = -1; j <= 1; j++)
					{
						for(int k = -size; k <= size; k++)
						{
							if(Math.abs(i) + Math.abs(j) + Math.abs(k) <= size)
							{
								buildBlock(world, pos.add(i, j, k), leaveBlock, leaveMeta);
							}
						}
					}
				}
				world.setBlockState(pos.down(), logBlock.getStateFromMeta(logMeta), 0);
			}
		}
	}
	
	public void buildBlock(World world, BlockPos pos, Block block, int meta)
	{
		Block b = world.getBlockState(pos).getBlock();
		if(b.getMaterial() == Material.air || b.getMaterial() == Material.vine || b.getMaterial() == Material.plants || b == Blocks.snow_layer)
		{
			world.setBlockState(pos, block.getStateFromMeta(meta), 0);
		}
	}
}