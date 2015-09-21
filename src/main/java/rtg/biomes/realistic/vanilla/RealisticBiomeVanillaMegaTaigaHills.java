package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaMegaTaigaHills;
import rtg.terrain.vanilla.TerrainVanillaMegaTaigaHills;

public class RealisticBiomeVanillaMegaTaigaHills extends RealisticBiomeVanilla
{	
	public static Block topBlock = BiomeGenBase.megaTaigaHills.topBlock;
	public static Block fillerBlock = BiomeGenBase.megaTaigaHills.fillerBlock;
	
	public RealisticBiomeVanillaMegaTaigaHills()
	{
		super(
			BiomeGenBase.megaTaigaHills,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.COLD),
			new TerrainVanillaMegaTaigaHills(230f, 120f, 90f),
			new SurfaceVanillaMegaTaigaHills(topBlock, fillerBlock, true, Blocks.sand, 0.2f)
		);
	}	
}
