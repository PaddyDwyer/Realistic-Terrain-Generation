package rtg.world.gen.surface.vanilla;

import java.util.Random;

import rtg.util.CellNoise;
import rtg.util.CliffCalculator;
import rtg.util.PerlinNoise;
import rtg.util.SnowHeightCalculator;
import rtg.world.gen.surface.SurfaceBase;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.util.CellNoise;
import rtg.util.CliffCalculator;
import rtg.util.PerlinNoise;

public class SurfaceVanillaColdTaiga extends SurfaceBase
{
	public SurfaceVanillaColdTaiga(IBlockState top, IBlockState fill) 
	{
		super(top, fill);
	}
	
	@Override
	public void paintTerrain(ChunkPrimer chunkPrimer, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
	{
		float p = perlin.noise2(i / 8f, j / 8f) * 0.5f;
		float c = CliffCalculator.calc(x, y, noise);
		int cliff = 0;
		boolean gravel = false;
		
    	Block b;
		for(int k = 255; k > -1; k--)
		{
			b = chunkPrimer.getBlockState((y * 16 + x) * 256 + k).getBlock();
            if(b == Blocks.air)
            {
            	depth = -1;
            }
            else if(b == Blocks.stone)
            {
            	depth++;
            	
            	if(depth == 0)
            	{
            		if(k < 63)
            		{
            			gravel = true;
            		}
            		
        			if(c > 0.45f && c > 1.5f - ((k - 60f) / 65f) + p)
        			{
        				cliff = 1;
        			}
            		if(c > 1.5f)
        			{
        				cliff = 2;
        			}
        			if(k > 110 + (p * 4) && c < 0.3f + ((k - 100f) / 50f) + p)
        			{
        				cliff = 3;
        			}
            		
            		if(cliff == 1)
            		{
            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, rand.nextInt(3) == 0 ? Blocks.cobblestone.getDefaultState() : Blocks.stone.getDefaultState());
            		}
            		else if(cliff == 2)
            		{
        				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.stained_hardened_clay.getStateFromMeta(9));
            		}
            		else if(cliff == 3)
            		{
	        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.snow.getDefaultState());
            		}
            		else if(perlin.noise2(i / 50f, j / 50f) + p * 0.6f > 0.24f)
        			{
            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.dirt.getStateFromMeta(2));
        			}
            		else if(k < 63)
            		{
            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.gravel.getDefaultState());
            			gravel = true;
            		}
            		else
            		{
            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.grass.getDefaultState());
            		}
            	}
            	else if(depth < 6)
        		{
            		if(cliff == 1)
            		{
            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.stone.getDefaultState());
            		}
            		else if(cliff == 2)
            		{
        				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.stained_hardened_clay.getStateFromMeta(9));
            		}
            		else if(cliff == 3)
            		{
	        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.snow.getDefaultState());
            		}
            		else if(gravel)
            		{
            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.gravel.getDefaultState());
            		}
            		else
            		{
            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.dirt.getDefaultState());
            		}
        		}
            }
		}
	}
}
