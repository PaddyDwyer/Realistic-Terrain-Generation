package rtg.biomes.realistic.vanilla;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.GeneratorBushFeature;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenDesertWells;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenerator;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.deco.DecoCacti;
import rtg.deco.trees.DecoSavannah;
import rtg.surface.vanilla.SurfaceVanillaDesert;
import rtg.terrain.vanilla.TerrainVanillaDesert;
import rtg.util.CellNoise;
import rtg.util.PerlinNoise;

public class RealisticBiomeVanillaDesert extends RealisticBiomeVanilla
{	
	public RealisticBiomeVanillaDesert()
	{
		super(
			BiomeGenBase.desert,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.OASIS),
			new TerrainVanillaDesert(),
			new SurfaceVanillaDesert(BiomeGenBase.desert.topBlock, BiomeGenBase.desert.fillerBlock)
		);
	}	
	@Override
    public void rDecorate(World world, Random rand, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float strength, float river)
    {

		if(rand.nextInt((int)(4f / strength)) == 0)
	       {
	           int k = chunkX + rand.nextInt(360) + 8;
	           int l = chunkY + rand.nextInt(360) + 8;
	           WorldGenDesertWells worldgendesertwells = new WorldGenDesertWells();
	           worldgendesertwells.generate(world, rand, new BlockPos(k, world.getTopSolidOrLiquidBlock(new BlockPos(k, 0, l)).getY() + 1, l));
	        }	
		if(river > 0.7f)
		{
			if(river > 0.86f)
			{
				for(int b33 = 0; b33 < 10f * strength; b33++)
				{
					int j6 = chunkX + rand.nextInt(16) + 8;
					int k10 = chunkY + rand.nextInt(16) + 8;
					int z52 = world.getTopSolidOrLiquidBlock(new BlockPos(j6, 0, k10)).getY();
	
					if(z52 < 100f || (z52 < 120f && rand.nextInt(10) == 0))
					{
						WorldGenerator worldgenerator = rand.nextInt(4) != 0 ? new WorldGenShrub(0, 0) : new DecoSavannah(1);
						worldgenerator.setScale(1.0D, 1.0D, 1.0D);
						worldgenerator.generate(world, rand, new BlockPos(j6, z52, k10));
					}
				}
			}
			
			for(int k18 = 0; k18 < 12f * strength; k18++)
			{
				int k21 = chunkX + rand.nextInt(16) + 8;
				int j23 = rand.nextInt(160);
				int k24 = chunkY + rand.nextInt(16) + 8;
				if(j23 < 120f)
				{
					(new DecoCacti(false)).generate(world, rand, k21, j23, k24);
				}
			}
		}
		
		
		for(int i15 = 0; i15 < 1f * strength; i15++)
		{
			int i17 = chunkX + rand.nextInt(16) + 8;
			int i20 = 64 + rand.nextInt(64);
			int l22 = chunkY + rand.nextInt(16) + 8;
			(new GeneratorBushFeature(Blocks.deadbush)).generate(world, rand, new BlockPos(i17, i20, l22));
		}
    }
}
