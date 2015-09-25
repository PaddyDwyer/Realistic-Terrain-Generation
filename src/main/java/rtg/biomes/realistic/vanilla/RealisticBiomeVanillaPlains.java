package rtg.biomes.realistic.vanilla;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaPlains;
import rtg.terrain.vanilla.TerrainVanillaPlains;

public class RealisticBiomeVanillaPlains extends RealisticBiomeVanilla
{	
	public RealisticBiomeVanillaPlains()
	{
		super(
			BiomeGenBase.plains,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE),
			new TerrainVanillaPlains(),
			new SurfaceVanillaPlains(BiomeGenBase.plains.topBlock, BiomeGenBase.plains.fillerBlock, Blocks.stone, Blocks.cobblestone)
		);
	}
	
	/*public void rDecorate(World world, Random rand, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float strength, float river)
	{
		float l = perlin.noise2((chunkX + 16f) / 60f, (chunkY + 16f) / 60f) * 6f + 0.2f;
		
		for (int b1 = 0; b1 < l * 4f * strength; b1++)
		{
			int j6 = chunkX + rand.nextInt(16) + 8;
			int k10 = chunkY + rand.nextInt(16) + 8;
			int z52 = world.getTopSolidOrLiquidBlock(new BlockPos(j6, 0, k10)).getY();
	
			if(z52 < 110)
			{
				WorldGenerator worldgenerator = rand.nextInt(6) == 0 ? new WorldGenTrees(false) : rand.nextInt(12) == 0 ? new DecoBirch(4 + rand.nextInt(5), 6 + rand.nextInt(5)) : rand.nextInt(6) == 0 ? new DecoSmallPine(3 + rand.nextInt(2), 3 + rand.nextInt(3), 0) : new DecoSmallPine(6 + rand.nextInt(5), 3 + rand.nextInt(6), 0);
				worldgenerator.setScale(1.0D, 1.0D, 1.0D);
				worldgenerator.generate(world, rand, new BlockPos(j6, z52, k10));
			}
			
			if(z52 < 120)
			{
				WorldGenerator worldgenerator = new DecoWillow();
				worldgenerator.setScale(1.0D, 1.0D, 1.0D);
				worldgenerator.generate(world, rand, new BlockPos(j6, z52, k10));
			}
			
			for(int f23 = 0; f23 < 8f * strength; f23++)
			{
				int j15 = chunkX + rand.nextInt(16) + 8;
				int j17 = rand.nextInt(128);
				int j20 = chunkY + rand.nextInt(16) + 8;
				(new DecoFlowers(new int[]{0,1,2,3,4,5,6,7,8,9,10,11})).generate(world, rand, new BlockPos(j15, j17, j20));
			}
		}
	}*/
}
