package rtg.biomes.realistic.vanilla;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaColdBeach;
import rtg.terrain.vanilla.TerrainVanillaColdBeach;

public class RealisticBiomeVanillaColdBeach extends RealisticBiomeVanilla
{	
	public RealisticBiomeVanillaColdBeach()
	{
		super(
			BiomeGenBase.coldBeach,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.COLD),
			new TerrainVanillaColdBeach(),
			new SurfaceVanillaColdBeach(BiomeGenBase.coldBeach.topBlock, BiomeGenBase.coldBeach.fillerBlock, BiomeGenBase.coldBeach.topBlock, BiomeGenBase.coldBeach.fillerBlock, (byte)0)
		);
	}	
}
