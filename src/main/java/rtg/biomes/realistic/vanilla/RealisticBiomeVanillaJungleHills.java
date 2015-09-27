package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaJungleHills;
import rtg.terrain.vanilla.TerrainVanillaJungleHills;

public class RealisticBiomeVanillaJungleHills extends RealisticBiomeVanilla
{	
	public static IBlockState topBlock = BiomeGenBase.jungleHills.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.jungleHills.fillerBlock;
	
	public RealisticBiomeVanillaJungleHills()
	{
		super(
			BiomeGenBase.jungleHills,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.WET),
			new TerrainVanillaJungleHills(),
			new SurfaceVanillaJungleHills(topBlock, fillerBlock, Blocks.stone.getDefaultState(), Blocks.cobblestone.getDefaultState())
		);
	}	
}
