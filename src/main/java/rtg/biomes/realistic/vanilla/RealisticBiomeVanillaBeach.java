package rtg.biomes.realistic.vanilla;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.deco.trees.DecoPalm;
import rtg.surface.vanilla.SurfaceVanillaBeach;
import rtg.terrain.vanilla.TerrainVanillaBeach;
import rtg.util.CellNoise;
import rtg.util.PerlinNoise;

public class RealisticBiomeVanillaBeach extends RealisticBiomeVanilla
{	
	public RealisticBiomeVanillaBeach()
	{
		super(
			BiomeGenBase.beach,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.OASIS),
			new TerrainVanillaBeach(),
			new SurfaceVanillaBeach(BiomeGenBase.beach.topBlock, BiomeGenBase.beach.fillerBlock, BiomeGenBase.beach.topBlock, BiomeGenBase.beach.fillerBlock, (byte)0, 1)
		);
	}
	
	    public void rDecorate(World world, Random rand, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float strength, float river)
	    {
	    	
	    	if(rand.nextInt((int)(2f / strength)) == 0)
			{
				int j6 = chunkX + rand.nextInt(16) + 8;
				int k10 = chunkY + rand.nextInt(16) + 8;
				int z52 = world.getTopSolidOrLiquidBlock(new BlockPos(j6, 0, k10)).getY();

				if(z52 < 80)
				{
					WorldGenerator worldgenerator = new DecoPalm();
					worldgenerator.generate(world, rand, new BlockPos(j6, z52, k10));
				}
			}
            }
	
}
