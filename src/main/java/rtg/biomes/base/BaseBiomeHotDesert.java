package rtg.biomes.base;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.data.VillageMaterialData;
import rtg.data.VillageMaterials;

public class BaseBiomeHotDesert extends BiomeGenBase
{
	public BaseBiomeHotDesert(int id, String bn) 
	{
		super(id);
		setTemperatureRainfall(1f, 0f);
		setBiomeName(bn);
		setDisableRain();
		spawnableCreatureList.clear();
		
		VillageMaterialData vmd = new VillageMaterialData(this);
		vmd.plankBlock = Blocks.sandstone.getDefaultState();
		vmd.logBlock = Blocks.sandstone.getDefaultState();
		vmd.pathBlock = Blocks.sandstone.getDefaultState();
		vmd.stairsWoodBlock = Blocks.sandstone_stairs.getDefaultState();
		vmd.slabsBlock = Blocks.acacia_fence.getDefaultState();
		vmd.cobbleBlock = Blocks.sandstone.getDefaultState();
		VillageMaterials.registerVillageMaterial(vmd);
	}
}
