package rtg.biomes.realistic.savanna;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenerator;
import rtg.api.RTGBiomes;
import rtg.biomes.realistic.RealisticBiomeBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.config.ConfigRTG;
import rtg.deco.DecoBlob;
import rtg.deco.DecoCacti;
import rtg.deco.DecoFlowers;
import rtg.deco.DecoGrass;
import rtg.deco.trees.DecoSavannah;
import rtg.surface.SurfaceBase;
import rtg.surface.SurfaceGrasslandMix1;
import rtg.terrain.TerrainBase;
import rtg.terrain.TerrainGrasslandFlats;
import rtg.util.CellNoise;
import rtg.util.PerlinNoise;

public class RealisticBiomeSavanna extends RealisticBiomeBase
{	
	private TerrainBase terrain;
	private SurfaceBase surface;

	public RealisticBiomeSavanna() 
	{
		super(0, RTGBiomes.baseHotPlains, VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.HOT));
		terrain = new TerrainGrasslandFlats();
		surface = new SurfaceGrasslandMix1(Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.stone, Blocks.cobblestone, 13f, 0.27f);
	}

	@Override
    public void rDecorate(World world, Random rand, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float strength, float river)
    {
		if ( ConfigRTG.enableCobblestoneBoulders && DecoBlob.shouldGenerateCobblestoneBoulder() ) {
			for (int i23 = 0; i23 < 1; i23++)
			{
				int i1 = chunkX + rand.nextInt(16) + 8;
				int j1 = chunkY + rand.nextInt(16) + 8;
				int k1 = world.getTopSolidOrLiquidBlock(new BlockPos(i1, 0, j1)).getY();
				(new WorldGenBlockBlob(Blocks.cobblestone, 0)).generate(world, rand, new BlockPos(i1, k1, j1));
			}
		}
		
		if(river > 0.8f)
		{
			for(int b33 = 0; b33 < 15f * strength; b33++)
			{
				int j6 = chunkX + rand.nextInt(16) + 8;
				int k10 = chunkY + rand.nextInt(16) + 8;
				int z52 = world.getTopSolidOrLiquidBlock(new BlockPos(j6, 0, k10)).getY();

				WorldGenerator worldgenerator = rand.nextInt(3) != 0 ? new WorldGenShrub(0, 0) : rand.nextInt(7) == 0 ? new DecoSavannah(1): new DecoSavannah(2);
				worldgenerator.generate(world, rand, new BlockPos(j6, z52, k10));
			}
			
			for(int f25 = 0; f25 < 2f * strength; f25++)
			{
				int i18 = chunkX + rand.nextInt(16) + 8;
				int i23 = chunkY + rand.nextInt(16) + 8;
				(new WorldGenReed()).generate(world, rand, new BlockPos(i18, 60 + rand.nextInt(8), i23));
			}
		}
		else if(perlin.noise2(chunkX / 180f, chunkY / 180f) > 0.20f)
		{
			for(int b33 = 0; b33 < 7f * strength; b33++)
			{
				int j6 = chunkX + rand.nextInt(16) + 8;
				int k10 = chunkY + rand.nextInt(16) + 8;
				int z52 = world.getTopSolidOrLiquidBlock(new BlockPos(j6, 0, k10)).getY();

				WorldGenerator worldgenerator = rand.nextInt(9) == 0 ? new WorldGenShrub(0, 0) : rand.nextInt(7) == 0 ? new DecoSavannah(1): new DecoSavannah(2);
				worldgenerator.generate(world, rand, new BlockPos(j6, z52, k10));
			}
		}
		else
		{
			int a = 3 - (int)(perlin.noise2(chunkX / 100f, chunkY / 100f) * 7);
			if(a < 1 || rand.nextInt(a) == 0)
			{
				int j6 = chunkX + rand.nextInt(16) + 8;
				int k10 = chunkY + rand.nextInt(16) + 8;
				int z52 = world.getTopSolidOrLiquidBlock(new BlockPos(j6, 0, k10)).getY();
	
				WorldGenerator worldgenerator = rand.nextBoolean() ? new WorldGenShrub(0, 0) : rand.nextInt(5) == 0 ? new DecoSavannah(0) : new DecoSavannah(1);
				worldgenerator.generate(world, rand, new BlockPos(j6, z52, k10));
			}
		}
		
		if(rand.nextInt((int)(3f / strength)) == 0) 
		{
			int i18 = chunkX + rand.nextInt(16) + 8;
			int i23 = chunkY + rand.nextInt(16) + 8;
			(new WorldGenReed()).generate(world, rand, new BlockPos(i18, 60 + rand.nextInt(8), i23));
		}
		
		if(rand.nextInt(28) == 0)
		{
			int j16 = chunkX + rand.nextInt(16) + 8;
			int j18 = rand.nextInt(128);
			int j21 = chunkY + rand.nextInt(16) + 8;
			(new WorldGenPumpkin()).generate(world, rand, new BlockPos(j16, j18, j21));
		}
		
		for(int f23 = 0; f23 < 3; f23++)
		{
			int j15 = chunkX + rand.nextInt(16) + 8;
			int j17 = rand.nextInt(128);
			int j20 = chunkY + rand.nextInt(16) + 8;
			(new DecoFlowers(new int[]{9,9,9,9,3,3,3,3,3,2,2,2,11,11,11})).generate(world, rand, new BlockPos(j15, j17, j20));
		}
		
		for(int k18 = 0; k18 < 12; k18++)
		{
			int k21 = chunkX + rand.nextInt(16) + 8;
			int j23 = rand.nextInt(160);
			int k24 = chunkY + rand.nextInt(16) + 8;
			(new DecoCacti(false)).generate(world, rand, new BlockPos(k21, j23, k24));
		}
		
		for(int l14 = 0; l14 < 15; l14++)
		{
			int l19 = chunkX + rand.nextInt(16) + 8;
			int k22 = rand.nextInt(128);
			int j24 = chunkY + rand.nextInt(16) + 8;

			if(rand.nextInt(6) == 0)
			{
				(new DecoGrass(Blocks.double_plant, 2)).generate(world, rand, new BlockPos(l19, k22, j24));
			}
			else
			{
				(new DecoGrass(Blocks.tallgrass, 1)).generate(world, rand, new BlockPos(l19, k22, j24));
			}
		}
    }
    
    public float rNoise(PerlinNoise perlin, CellNoise cell, int x, int y, float ocean, float border, float river)
    {
    	return terrain.generateNoise(perlin, cell, x, y, ocean, border, river);
    }
    
    public void rReplace(Block[] blocks, byte[] metadata, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
    {
    	surface.paintTerrain(blocks, metadata, i, j, x, y, depth, world, rand, perlin, cell, noise, river, base);
    }
}
