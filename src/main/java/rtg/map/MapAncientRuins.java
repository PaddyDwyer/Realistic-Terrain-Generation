package rtg.map;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.util.CellNoise;
import rtg.util.PerlinNoise;

public class MapAncientRuins 
{
	public static void build(ChunkPrimer chunkPrimer, World world, Random mapRand, int chunkX, int chunkY, int baseX, int baseY, PerlinNoise perlin, CellNoise cell, int dis)
	{
    	int y = 120;
    	for(; y > 49; y--)
    	{
    		if(chunkPrimer.getBlockState(coordstoArray(8, y - 1, 8)).getBlock() != Blocks.air)
    		{
    			if(y > 118)
    			{
    	    		return;
    			}
    			break;
    		}
    		
    		if(y < 51)
    		{
    			return;
    		}
    	}
    	
    	int sizeX = mapRand.nextInt(5) + 10 - (dis * 2);
    	int sizeZ = mapRand.nextInt(5) + 10 - (dis * 2);
    	int startX = mapRand.nextInt(2) + dis;
    	int startZ = mapRand.nextInt(2) + dis;
    	int i, j, height;
    	
    	for(i = startX; i < startX + sizeX; i++)
    	{
    		if(chunkPrimer.getBlockState(coordstoArray(8, y - 1, 8)).getBlock() != Blocks.air)
    		{
        		height = mapRand.nextInt(4);
        		for(j = 0; j < height; j++)
        		{
        			chunkPrimer.setBlockState(coordstoArray(startX + i, y + j - 1, startZ), Blocks.mossy_cobblestone.getDefaultState());
        		}
    		}

    		if(chunkPrimer.getBlockState(coordstoArray(8, y - 1, 8)).getBlock() != Blocks.air)
    		{
	    		height = mapRand.nextInt(4);
	    		for(j = 0; j < height; j++)
	    		{
	    			chunkPrimer.setBlockState(coordstoArray(startX + i, y + j - 1, startZ + sizeZ), Blocks.mossy_cobblestone.getDefaultState());
	    		}
    		}
    	}
    	
    	for(i = startZ + 1; i < startZ + sizeZ - 1; i++)
    	{
    		if(chunkPrimer.getBlockState(coordstoArray(8, y - 1, 8)).getBlock() != Blocks.air)
    		{
        		height = mapRand.nextInt(4);
        		for(j = 0; j < height; j++)
        		{
        			chunkPrimer.setBlockState(coordstoArray(startX, y + j - 1, startZ + i), Blocks.mossy_cobblestone.getDefaultState());
        		}
    		}

    		if(chunkPrimer.getBlockState(coordstoArray(8, y - 1, 8)).getBlock() != Blocks.air)
    		{
	    		height = mapRand.nextInt(4);
	    		for(j = 0; j < height; j++)
	    		{
	    			chunkPrimer.setBlockState(coordstoArray(startX + sizeX, y + j - 1, startZ + i), Blocks.mossy_cobblestone.getDefaultState());
	    		}
    		}
    	}
	}
    
    public static int coordstoArray(int x, int y, int z)
    {
    	return (z * 16 + x) * 256 + y;
    }
}
