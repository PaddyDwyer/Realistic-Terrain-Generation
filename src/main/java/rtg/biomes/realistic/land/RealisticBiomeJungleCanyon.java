package rtg.biomes.realistic.land;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.world.gen.feature.WorldGenerator;
import rtg.api.RTGBiomes;
import rtg.biomes.realistic.RealisticBiomeBase;
import rtg.config.ConfigRTG;
import rtg.deco.DecoBlob;
import rtg.deco.trees.DecoJungleSmall;
import rtg.surface.SurfaceBase;
import rtg.surface.SurfaceGrassCanyon;
import rtg.terrain.TerrainBase;
import rtg.terrain.TerrainCanyon;
import rtg.util.CellNoise;
import rtg.util.PerlinNoise;

public class RealisticBiomeJungleCanyon extends RealisticBiomeBase
{
	private TerrainBase terrain;
	private SurfaceBase surface;
	
	public RealisticBiomeJungleCanyon() 
	{
		super(0, RTGBiomes.baseHotForest);

		terrain = new TerrainCanyon(true, 35f, 160f, 60f, 40f, 69f);
		surface = new SurfaceGrassCanyon(Blocks.grass.getDefaultState(), Blocks.dirt.getDefaultState(), Blocks.stained_hardened_clay.getStateFromMeta(0));
	}

	@Override
    public void rDecorate(World world, Random rand, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float strength, float river)
    {
		if ( ConfigRTG.enableCobblestoneBoulders && DecoBlob.shouldGenerateCobblestoneBoulder() ) {
			for (int l = 0; l < 1f * strength; ++l)
			{
				int i1 = chunkX + rand.nextInt(16) + 8;
				int j1 = chunkY + rand.nextInt(16) + 8;
				int k1 = world.getTopSolidOrLiquidBlock(new BlockPos(i1, 0, j1)).getY();
				
				if (k1 < 70)
				{
					(new WorldGenBlockBlob(Blocks.mossy_cobblestone, 0)).generate(world, rand, new BlockPos(i1, k1, j1));
				}
			}
		}
		
		for(int a = 0; a < 5f * strength; a++)
		{
			int j6 = chunkX + rand.nextInt(16) + 8;
			int k10 = chunkY + rand.nextInt(16) + 8;
			int z52 = world.getTopSolidOrLiquidBlock(new BlockPos(j6, 0, k10)).getY();
	
			WorldGenerator worldgenerator = new DecoJungleSmall(Blocks.log, 3, Blocks.leaves, 3, 1 + rand.nextInt(4), 0, 5f, 2, 0.32f, 0.14f);
			worldgenerator.generate(world, rand, new BlockPos(j6, z52, k10));
		}
	}
    
	@Override
    public float rNoise(PerlinNoise perlin, CellNoise cell, int x, int y, float ocean, float border, float river)
    {
    	return terrain.generateNoise(perlin, cell, x, y, ocean, border, river);
    }
    
    @Override
    public void rReplace(ChunkPrimer chunkPrimer, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
    {
    	surface.paintTerrain(chunkPrimer, i, j, x, y, depth, world, rand, perlin, cell, noise, river, base);
    }
}
