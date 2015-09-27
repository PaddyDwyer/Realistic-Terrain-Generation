package rtg.world.gen.surface.vanilla;

import java.util.Random;



import rtg.util.CellNoise;
import rtg.util.PerlinNoise;
import rtg.world.gen.surface.SurfaceBase;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.api.RTGBiomes;
import rtg.surface.SurfaceBase;
import rtg.util.CellNoise;
import rtg.util.PerlinNoise;

public class SurfaceVanillaSavannaPlateau extends SurfaceBase
{
	private float valley;
	private boolean dirt;
	private boolean mix;
	
	public SurfaceVanillaSavannaPlateau(IBlockState top, IBlockState fill, float valleySize, boolean d, boolean m) 
	{
		super(top, fill);
		
		valley = valleySize;
		dirt = d;
		mix = m;
	}
	
	@Override
	public void paintTerrain(ChunkPrimer chunkPrimer, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
	{
    	float h = (perlin.noise2(i / valley, j / valley) + 0.25f) * 65f;
    	h = h < 1f ? 1f : h;
		float m = perlin.noise2(i / 12f, j / 12f);
		boolean sand = false;
		
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
                	if(k > 90f + perlin.noise2(i / 24f, j / 24f) * 10f - h || (m < -0.28f && mix))
        			{
    					chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.sand.getDefaultState());
    					base[x * 16 + y] = RTGBiomes.baseHotDesert;
    					blocks[(y * 16 + x) * 256 + k] = Blocks.sand;
    					base[x * 16 + y] = BiomeGenBase.desert;
    					sand = true;
        			}
        			else if(dirt && m < 0.22f || k < 62)
        			{
    					chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.dirt.getStateFromMeta(1));
        			}
        			else
        			{
    					chunkPrimer.setBlockState((y * 16 + x) * 256 + k, topBlock);
        			}
        		}
        		else if(depth < 6)
        		{
        			if(sand)
        			{
        				if(depth < 4)
        				{
            				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.sand.getDefaultState());
        				}
        				else
        				{
            				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.sandstone.getDefaultState());
        				}
        			}
        			else
        			{
        				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, fillerBlock);
        			}
        		}
            }
		}
	}
}
