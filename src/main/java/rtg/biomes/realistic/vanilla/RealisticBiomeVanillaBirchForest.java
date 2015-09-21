package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaBirchForest;
import rtg.terrain.vanilla.TerrainVanillaBirchForest;

public class RealisticBiomeVanillaBirchForest extends RealisticBiomeVanilla
{	
	public static Block topBlock = BiomeGenBase.birchForest.topBlock;
	public static Block fillerBlock = BiomeGenBase.birchForest.fillerBlock;
	
	public RealisticBiomeVanillaBirchForest()
	{
		super(
			BiomeGenBase.birchForest,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE),
			new TerrainVanillaBirchForest(),
			new SurfaceVanillaBirchForest(topBlock, fillerBlock, Blocks.stone, Blocks.cobblestone)
		);
	}	
}
