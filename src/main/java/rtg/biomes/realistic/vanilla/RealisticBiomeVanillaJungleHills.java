package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaJungleHills;
import rtg.terrain.vanilla.TerrainVanillaJungleHills;

public class RealisticBiomeVanillaJungleHills extends RealisticBiomeVanilla
{	
	public static Block topBlock = BiomeGenBase.jungleHills.topBlock;
	public static Block fillerBlock = BiomeGenBase.jungleHills.fillerBlock;
	
	public RealisticBiomeVanillaJungleHills()
	{
		super(
			BiomeGenBase.jungleHills,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.WET),
			new TerrainVanillaJungleHills(),
			new SurfaceVanillaJungleHills(topBlock, fillerBlock, Blocks.stone, Blocks.cobblestone)
		);
	}	
}
