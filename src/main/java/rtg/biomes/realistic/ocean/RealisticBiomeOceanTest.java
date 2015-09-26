package rtg.biomes.realistic.ocean;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.api.RTGBiomes;
import rtg.biomes.realistic.RealisticBiomeBase;
import rtg.util.CellNoise;
import rtg.util.PerlinNoise;

public class RealisticBiomeOceanTest extends RealisticBiomeBase
{
	public RealisticBiomeOceanTest() 
	{
		super(0, RTGBiomes.baseColdPlains);
	}
	
	@Override
    public void rDecorate(World world, Random rand, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float strength, float river)
    {
    }

	@Override
    public float rNoise(PerlinNoise perlin, CellNoise cell, int x, int y, float ocean, float border, float river)
    {
		return 45f;
    }

	@Override
    public void rReplace(ChunkPrimer chunkPrimer, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
    {
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
    				if(k < 62)
    				{
    					chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.sand.getDefaultState());
    				}
    				else
    				{
    					chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.sand.getDefaultState());
    				}
        		}
        		else if(depth < 6)
        		{
					chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.sand.getDefaultState());
        		}
            }
		}
    }
}
