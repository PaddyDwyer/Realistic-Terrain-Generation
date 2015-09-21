package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaSavanna;
import rtg.terrain.vanilla.TerrainVanillaSavanna;

public class RealisticBiomeVanillaSavanna extends RealisticBiomeVanilla
{	
	public static Block topBlock = BiomeGenBase.savanna.topBlock;
	public static Block fillerBlock = BiomeGenBase.savanna.fillerBlock;
	
	public RealisticBiomeVanillaSavanna()
	{
		super(
			BiomeGenBase.savanna,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.HOT),
			new TerrainVanillaSavanna(),
			new SurfaceVanillaSavanna(topBlock, fillerBlock, Blocks.stone, Blocks.cobblestone)
		);
	}	
}
