package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaMushroomIslandShore;
import rtg.terrain.vanilla.TerrainVanillaMushroomIslandShore;

public class RealisticBiomeVanillaMushroomIslandShore extends RealisticBiomeVanilla
{	
	public static Block topBlock = BiomeGenBase.mushroomIslandShore.topBlock;
	public static Block fillerBlock = BiomeGenBase.mushroomIslandShore.fillerBlock;
	
	public RealisticBiomeVanillaMushroomIslandShore()
	{
		super(
			BiomeGenBase.mushroomIslandShore,
			VanillaBiomes.climatizedBiome(BiomeGenBase.ocean, Climate.COLD),
			new TerrainVanillaMushroomIslandShore(),
			new SurfaceVanillaMushroomIslandShore(topBlock, fillerBlock, 67, topBlock, 0f)
		);
	}	
}
