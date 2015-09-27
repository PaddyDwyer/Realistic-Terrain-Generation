package rtg.world.biome.realistic.vanilla;

import rtg.world.biome.BiomeBase;
import rtg.world.biome.BiomeBase.Climate;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.vanilla.SurfaceVanillaJungleHills;
import rtg.world.gen.terrain.vanilla.TerrainVanillaJungleHills;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaJungleHills;
import rtg.terrain.vanilla.TerrainVanillaJungleHills;

public class RealisticBiomeVanillaJungleHills extends RealisticBiomeVanillaBase
{	
	public static IBlockState topBlock = BiomeGenBase.jungleHills.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.jungleHills.fillerBlock;
	
	public RealisticBiomeVanillaJungleHills()
	{
		super(
			BiomeGenBase.jungleHills,
			BiomeBase.climatizedBiome(BiomeGenBase.river, BiomeBase.Climate.WET),
			new TerrainVanillaJungleHills(),
			new SurfaceVanillaJungleHills(topBlock, fillerBlock, Blocks.stone.getDefaultState(), Blocks.cobblestone.getDefaultState())
		);
	}	
}
