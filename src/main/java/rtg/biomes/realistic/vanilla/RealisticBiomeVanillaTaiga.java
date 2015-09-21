package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaTaiga;
import rtg.terrain.vanilla.TerrainVanillaTaiga;

public class RealisticBiomeVanillaTaiga extends RealisticBiomeVanilla
{	
	public static Block topBlock = BiomeGenBase.taiga.topBlock;
	public static Block fillerBlock = BiomeGenBase.taiga.fillerBlock;
	
	public RealisticBiomeVanillaTaiga()
	{
		super(
			BiomeGenBase.taiga,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.COLD),
			new TerrainVanillaTaiga(),
			new SurfaceVanillaTaiga(topBlock, fillerBlock)
		);
	}	
}
