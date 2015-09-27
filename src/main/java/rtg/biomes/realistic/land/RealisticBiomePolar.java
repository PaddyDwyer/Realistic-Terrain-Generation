package rtg.biomes.realistic.land;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import rtg.api.RTGBiomes;
import rtg.biomes.realistic.RealisticBiomeBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.deco.DecoBlob;
import rtg.deco.trees.DecoSmallSpruce;
import rtg.surface.SurfaceBase;
import rtg.surface.SurfacePolar;
import rtg.terrain.TerrainBase;
import rtg.terrain.TerrainPolar;
import rtg.util.CellNoise;
import rtg.util.PerlinNoise;

public class RealisticBiomePolar extends RealisticBiomeBase
{	
	private TerrainBase terrain;
	private SurfaceBase surface;
	
	public RealisticBiomePolar() 
	{
		super(0, RTGBiomes.baseSnowDesert, VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.ICE));
		terrain = new TerrainPolar();
		surface = new SurfacePolar(Blocks.snow.getDefaultState(), Blocks.snow.getDefaultState());
	}
	
	@Override
    public void rDecorate(World world, Random rand, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float strength, float river)
    {
		if(river > 0.86f)
		{
			for(int j = 0; j < 5f * strength; j++)
			{
				int i1 = chunkX + rand.nextInt(16) + 8;
				int j1 = chunkY + rand.nextInt(16) + 8;
			    int k1 = world.getTopSolidOrLiquidBlock(new BlockPos(i1, 0, j1)).getY();
				if(k1 < 64)
				{
					(new DecoBlob(Blocks.packed_ice, 0)).generate(world, rand, new BlockPos(i1, k1, j1));
				}
			}
			
			if(rand.nextInt((int)(2f / strength)) == 0)
			{
				int j6 = chunkX + rand.nextInt(16) + 8;
				int k10 = chunkY + rand.nextInt(16) + 8;
				int z52 = world.getTopSolidOrLiquidBlock(new BlockPos(j6, 0, k10)).getY();
				
				WorldGenerator worldgenerator = new DecoSmallSpruce(rand.nextInt(2));
				worldgenerator.generate(world, rand, new BlockPos(j6, z52, k10));
			}
		}
    }
    
    public float rNoise(PerlinNoise perlin, CellNoise cell, int x, int y, float ocean, float border, float river)
    {
    	return terrain.generateNoise(perlin, cell, x, y, ocean, border, river);
    }
    
    public void rReplace(ChunkPrimer chunkPrimer, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
    {
    	surface.paintTerrain(chunkPrimer, i, j, x, y, depth, world, rand, perlin, cell, noise, river, base);
    }
}
