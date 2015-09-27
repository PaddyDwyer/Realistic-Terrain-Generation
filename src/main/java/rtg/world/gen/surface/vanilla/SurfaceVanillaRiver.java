package rtg.world.gen.surface.vanilla;

import java.util.Random;



import rtg.util.CellNoise;
import rtg.util.CliffCalculator;
import rtg.util.PerlinNoise;
import rtg.world.gen.surface.SurfaceBase;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.surface.SurfaceBase;
import rtg.util.CellNoise;
import rtg.util.CliffCalculator;
import rtg.util.PerlinNoise;

public class SurfaceVanillaRiver extends SurfaceBase
{
	private IBlockState cliffBlock1;
	private IBlockState cliffBlock2;
	private int cliffType;
	
	public SurfaceVanillaRiver(IBlockState top, IBlockState filler, IBlockState cliff1, IBlockState cliff2, int cliff)
	{
		super(top, filler);
		
		cliffBlock1 = cliff1;
		cliffBlock2 = cliff2;
		cliffType = cliff;
	}
	
	@Override
	public void paintTerrain(ChunkPrimer chunkPrimer, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
	{
		float c = CliffCalculator.calc(x, y, noise);
		boolean cliff = c > 1.3f ? true : false;
		boolean dirt = false;

		for(int k = 255; k > -1; k--)
		{
			Block b = chunkPrimer.getBlockState((y * 16 + x) * 256 + k).getBlock();
            if(b == Blocks.air)
            {
            	depth = -1;
            }
            else if(b == Blocks.stone)
            {
            	depth++;

            	if(cliff)
            	{
            		if(cliffType == 1)
            		{
            			if (depth < 6 && cliffBlock1.getBlock() == Blocks.stained_hardened_clay)
	            		{
                			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, cliffBlock1.getBlock().getStateFromMeta(14));
	            		}
            		}
            		else
            		{
	            		if(depth > -1 && depth < 2)
	            		{
	            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, rand.nextInt(3) == 0 ? cliffBlock2 : cliffBlock1);
	            		}
	            		else if (depth < 10)
	            		{
	            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, cliffBlock1);
	            		}
            		}
            	}
            	else if(depth < 6)
            	{
	        		if(depth == 0 && k > 61)
	        		{
	        			if(perlin.noise2(i / 12f, j / 12f) > -0.3f + ((k - 61f) / 15f))
	        			{
	        				dirt = true;
		        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, topBlock);
	        			}
	        			else
	        			{
		        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.sand.getDefaultState());
	        			}
	        		}
	        		else if(depth < 4)
	        		{
	        			if(dirt)
	        			{
	        				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, fillerBlock);
	        			}
	        			else
	        			{
	        				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.sand.getDefaultState());
	        			}
	        		}
	        		else if(!dirt)
	        		{
	        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.sandstone.getDefaultState());
	        		}
            	}
            }
		}
	}
}
