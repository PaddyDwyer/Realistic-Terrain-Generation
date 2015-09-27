package rtg.util;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.ChunkPrimer;

public class SnowHeightCalculator 
{
	public static void calc(int x, int y, int k, ChunkPrimer chunkPrimer, float[] noise)
	{
		if(k < 254)
		{
			byte h = (byte) ((noise[y * 16 + x] - ((int) noise[y * 16 + x])) * 8);
			
			if(h > 7)
			{
				chunkPrimer.setBlockState((y * 16 + x) * 256 + k + 2, Blocks.snow_layer.getStateFromMeta(7));
				chunkPrimer.setBlockState((y * 16 + x) * 256 + k + 1, Blocks.snow_layer.getStateFromMeta(7));
			}
			else
			{
				chunkPrimer.setBlockState((y * 16 + x) * 256 + k + 1, Blocks.snow_layer.getStateFromMeta(h));
			}
		}
	}
}
