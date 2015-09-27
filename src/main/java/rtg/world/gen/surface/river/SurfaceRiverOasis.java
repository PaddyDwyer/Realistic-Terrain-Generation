package rtg.world.gen.surface.river;

import java.util.Random;



import rtg.util.CellNoise;
import rtg.util.PerlinNoise;
import rtg.world.gen.surface.SurfaceBase;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class SurfaceRiverOasis extends SurfaceBase
{
	public SurfaceRiverOasis() 
	{
		super(Blocks.grass.getDefaultState(), Blocks.dirt.getDefaultState());
	}
	
	@Override
	public void paintTerrain(ChunkPrimer chunkPrimer, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
	{
		if(river > 0.05f && river + (perlin.noise2(i / 10f, j / 10f) * 0.15f) > 0.8f)
		{
			Block b;
			for(int k = 255; k > -1; k--)
			{
				b = chunkPrimer.getBlockState((y * 16 + x) * 256 + k).getBlock();
	            if(b == Blocks.air)
	            {
	            	depth = -1;
	            }
	            else if(b != Blocks.water)
	            {
	            	depth++;
	            	
	        		if(depth == 0 && k > 61)
	        		{
	        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.grass.getDefaultState());
	        		}
	        		else if(depth < 4)
	        		{
	        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.dirt.getDefaultState());
	        		}
	        		else if(depth > 4)
	        		{
	        			return;
	        		}
	            }
			}
		}
	}
}
