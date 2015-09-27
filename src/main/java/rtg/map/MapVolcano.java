package rtg.map;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.util.CellNoise;
import rtg.util.PerlinNoise;
import rtg.util.TerrainMath;

public class MapVolcano 
{
	public static void build(ChunkPrimer chunkPrimer, World world, Random mapRand, int baseX, int baseY, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float[] noise)
	{	
		int i, j;
		float distance, height, obsidian;
		Block b;
		
		for (int x = 0; x < 16; x++)
		{
			for (int z = 0; z < 16; z++)
			{
				i = (chunkX * 16) + x;
				j = (chunkY * 16) + z;
				
				distance = (float)TerrainMath.dis2(i, j, baseX * 16, baseY * 16);
				obsidian = 140f + distance + perlin.noise2(i / 16f, j / 16f) * 15f;
				
				if(distance < 10 + perlin.noise2(i / 3f, j / 3f) * 1.5f)
				{
					height = perlin.noise2(i / 5f, j / 5f) * 2f;
					for (int y = 255; y > -1; y--)
					{
						if(y > 165)
						{
							if(chunkPrimer.getBlockState(cta(x, y, z)).getBlock() != Blocks.air)
							{
								chunkPrimer.setBlockState(cta(x, y, z), Blocks.air.getDefaultState());
							}
						}
						else if(y > obsidian && y < 156 + height)
						{
							chunkPrimer.setBlockState(cta(x, y, z), Blocks.obsidian.getDefaultState());
						}
						else if(y < 166)
						{
							chunkPrimer.setBlockState(cta(x, y, z), Blocks.lava.getDefaultState());
						}
						else if(y < obsidian + 1)
						{
							if(chunkPrimer.getBlockState(cta(x, y, z)).getBlock() == Blocks.air)
							{
								chunkPrimer.setBlockState(cta(x, y, z), Blocks.stone.getDefaultState());
							}
							else
							{
								break;
							}
						}
					}
				}
				else
				{
					height = 190f - (distance + perlin.noise2(i / 12f, j / 12f) * 5f) * 1.7f;
					if(height > noise[x * 16 + z])
					{
						noise[x * 16 + z] = height;
					}
					
					for (int y = 255; y > -1; y--)
					{
						if(y <= height)
						{
							b = chunkPrimer.getBlockState(cta(x, y, z)).getBlock(); 
							if(b == Blocks.air)
							{
								if(y > obsidian)
								{
									b = Blocks.obsidian;
								}
								else
								{
									b = Blocks.stone;
								}
							}
							else
							{
								break;
							}
							chunkPrimer.setBlockState(cta(x, y, z), b.getDefaultState());
						}
					}
				}
			}
		}
	}
	
    public static int cta(int x, int y, int z)
    {
    	return (x * 16 + z) * 256 + y;
    }
}
