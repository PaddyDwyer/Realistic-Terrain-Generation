package rtg.biomes.realistic.vanilla;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaStoneBeach;
import rtg.terrain.vanilla.TerrainVanillaStoneBeach;

public class RealisticBiomeVanillaStoneBeach extends RealisticBiomeVanilla
{	
	public RealisticBiomeVanillaStoneBeach()
	{
		super(
			BiomeGenBase.stoneBeach,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.OASIS),
			new TerrainVanillaStoneBeach(0f, 100f, 63f, 80f),
			new SurfaceVanillaStoneBeach(BiomeGenBase.stoneBeach.topBlock, BiomeGenBase.stoneBeach.fillerBlock, false, null, 1f, 1.5f, 85f, 20f, 4f)
		);
	}	
}
