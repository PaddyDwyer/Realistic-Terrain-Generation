package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaColdTaiga;
import rtg.terrain.vanilla.TerrainVanillaColdTaiga;

public class RealisticBiomeVanillaColdTaiga extends RealisticBiomeVanilla
{	
	public static Block topBlock = BiomeGenBase.coldTaiga.topBlock;
	public static Block fillerBlock = BiomeGenBase.coldTaiga.fillerBlock;
	
	public RealisticBiomeVanillaColdTaiga()
	{
		super(
			BiomeGenBase.coldTaiga,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.COLD),
			new TerrainVanillaColdTaiga(),
			new SurfaceVanillaColdTaiga(topBlock, fillerBlock)
		);
	}	
}
