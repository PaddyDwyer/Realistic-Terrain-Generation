package rtg.support;

import extrabiomes.api.BiomeManager;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.support.Support.BiomeCategory;
import rtg.support.edit.EditBase;
import rtg.support.edit.EditRiverOasis;
import rtg.surface.SurfaceBase;
import rtg.surface.SurfaceDesertMountain;
import rtg.surface.SurfaceGrassland;
import rtg.surface.SurfaceGrasslandMix1;
import rtg.surface.SurfaceMarshFix;
import rtg.surface.SurfaceMountainSnow;
import rtg.surface.SurfaceMountainStone;
import rtg.surface.SurfacePolar;
import rtg.surface.river.SurfaceRiverOasis;
import rtg.terrain.TerrainGrasslandFlats;
import rtg.terrain.TerrainGrasslandHills;
import rtg.terrain.TerrainHighland;
import rtg.terrain.TerrainHilly;
import rtg.terrain.TerrainMarsh;
import rtg.terrain.TerrainMountainRiver;
import rtg.terrain.TerrainMountainSpikes;
import rtg.terrain.TerrainPolar;
import rtg.terrain.TerrainSwampMountain;
import rtg.terrain.TerrainSwampRiver;

public class SupportEBXL 
{
	public static void init()
	{
	    //ALPINE
		if(BiomeManager.alpine.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.alpine.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.ICE),
					new TerrainMountainRiver(),
					new SurfaceMountainSnow(Blocks.grass, Blocks.dirt, false, null, 0.45f)
				), 
				BiomeCategory.SNOW
			);
		}
		
	    //AUTUMNWOODS
		if(BiomeManager.autumnwoods.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.autumnwoods.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE),
					new TerrainHighland(0f, 140f, 68f, 200f),
					new SurfaceGrassland(BiomeManager.autumnwoods.get().topBlock, BiomeManager.autumnwoods.get().fillerBlock, Blocks.stone, Blocks.cobblestone)
				), 
				BiomeCategory.COLD
			);
		}
		
		//BIRCHFOREST
		if(BiomeManager.birchforest.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.birchforest.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE),
					new TerrainHilly(230f, 120f, 0f),
					new SurfaceMountainStone(BiomeManager.birchforest.get().topBlock, BiomeManager.birchforest.get().fillerBlock, false, null, 0.95f)
				), 
				BiomeCategory.COLD
			);
		}
		
	    //EXTREME JUNGLE
		if(BiomeManager.extremejungle.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.extremejungle.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.WET),
					new TerrainSwampMountain(135f, 300f),
					new SurfaceMountainStone(BiomeManager.extremejungle.get().topBlock, BiomeManager.extremejungle.get().fillerBlock, false, null, 0.95f)
				), 
				BiomeCategory.WET
			);
		}
		
		//FORESTED ISLAND
		if(BiomeManager.forestedisland.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.forestedisland.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE),
					new TerrainGrasslandHills(90f, 180f, 13f, 100f, 1f, 260f, 59f),
					new SurfaceGrassland(BiomeManager.forestedisland.get().topBlock, BiomeManager.forestedisland.get().fillerBlock, Blocks.stone, Blocks.cobblestone)
				), 
				BiomeCategory.COLD
			);
		}
		
	    //FORESTED HILLS
		if(BiomeManager.forestedhills.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.forestedhills.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE),
					new TerrainHilly(230f, 120f, 0f),
					new SurfaceMountainStone(BiomeManager.forestedhills.get().topBlock, BiomeManager.forestedhills.get().fillerBlock, false, null, 0.95f)
				), 
				BiomeCategory.COLD
			);
		}
		
		//GLACIER
		if(BiomeManager.glacier.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.glacier.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.ICE),
					new TerrainGrasslandHills(90f, 180f, 13f, 100f, 38f, 260f, 71f),
					new SurfaceMountainStone(BiomeManager.glacier.get().topBlock, BiomeManager.glacier.get().fillerBlock, false, null, 0.95f)
				), 
				BiomeCategory.SNOW
			);
		}
		
		//GREENHILLS
		if(BiomeManager.greenhills.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.greenhills.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE),
					new TerrainHilly(230f, 120f, 0f),
					new SurfaceMountainStone(BiomeManager.greenhills.get().topBlock, BiomeManager.greenhills.get().fillerBlock, false, null, 0.95f)
				), 
				BiomeCategory.COLD
			);
		}
		
	    //ICEWASTELAND
		if(BiomeManager.icewasteland.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.icewasteland.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.ICE),
					new TerrainPolar(),
					new SurfacePolar(BiomeManager.icewasteland.get().topBlock, BiomeManager.icewasteland.get().fillerBlock)
				), 
				BiomeCategory.SNOW
			);
		}
		
		//GREENSWAMP
		if(BiomeManager.greenswamp.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.greenswamp.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.WET),
					new TerrainSwampRiver(),
					new SurfaceGrassland(BiomeManager.greenswamp.get().topBlock, BiomeManager.greenswamp.get().fillerBlock, Blocks.stone, Blocks.cobblestone)
				), 
				BiomeCategory.WET
			);
		}
		
	    //MARSH
		if(BiomeManager.marsh.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.marsh.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.WET),
					new TerrainMarsh(),
					new SurfaceMarshFix(BiomeManager.marsh.get().topBlock, BiomeManager.marsh.get().fillerBlock, Blocks.stone, Blocks.cobblestone)
				), 
				BiomeCategory.WET
			);
		}
		
	    //MEADOW
		if(BiomeManager.meadow.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.meadow.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.COLD),
					new TerrainGrasslandHills(90f, 180f, 13f, 100f, 38f, 260f, 71f),
					new SurfaceGrassland(BiomeManager.meadow.get().topBlock, BiomeManager.meadow.get().fillerBlock, Blocks.stone, Blocks.cobblestone)
				), 
				BiomeCategory.COLD
			);
		}
		
		//MINI JUNGLE
		if(BiomeManager.minijungle.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.minijungle.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.WET),
					new TerrainHighland(0f, 140f, 68f, 200f),
					new SurfaceGrassland(BiomeManager.minijungle.get().topBlock, BiomeManager.minijungle.get().fillerBlock, Blocks.stone, Blocks.cobblestone)
				), 
				BiomeCategory.WET
			);
		}
		
	    //MOUNTAIN DESERT
		if(BiomeManager.mountaindesert.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.mountaindesert.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.OASIS),
					new TerrainHilly(230f, 100f, 0f),
					new SurfaceBase[]{
						new SurfaceDesertMountain(BiomeManager.mountaindesert.get().topBlock, BiomeManager.mountaindesert.get().fillerBlock, false, null, 0f, 1.5f, 60f, 65f, 1.5f),
						new SurfaceRiverOasis()
					},
					new EditBase[]{
						new EditRiverOasis()
					}
				), 
				BiomeCategory.HOT
			);
		}
		
		//MOUNTAIN RIDGE
		if(BiomeManager.mountainridge.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.mountainridge.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.OASIS),
					new TerrainHilly(230f, 110f, 0f),
					new SurfaceBase[]{
						new SurfaceDesertMountain(BiomeManager.mountainridge.get().topBlock, BiomeManager.mountainridge.get().fillerBlock, false, null, 0f, 1.5f, 60f, 65f, 1.5f),
						new SurfaceRiverOasis()
					},
					new EditBase[]{
						new EditRiverOasis()
					}
				), 
				BiomeCategory.HOT
			);
		}
		
	    //MOUNTAIN TAIGA
		if(BiomeManager.mountaintaiga.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.mountaintaiga.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.ICE),
					new TerrainMountainSpikes(),
					new SurfaceMountainStone(BiomeManager.mountaintaiga.get().topBlock, BiomeManager.mountaintaiga.get().fillerBlock, false, null, 1.2f)
				), 
				BiomeCategory.SNOW
			);
		}
		
	    //PINE FOREST
		if(BiomeManager.pineforest.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.pineforest.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.COLD),
					new TerrainMountainSpikes(),
					new SurfaceMountainStone(BiomeManager.pineforest.get().topBlock, BiomeManager.pineforest.get().fillerBlock, false, null, 1.2f)
				), 
				BiomeCategory.COLD
			);
		}
		
	    //RAINFOREST
		if(BiomeManager.rainforest.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.rainforest.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.WET),
					new TerrainHilly(230f, 100f, 0f),
					new SurfaceGrassland(BiomeManager.rainforest.get().topBlock, BiomeManager.rainforest.get().fillerBlock, Blocks.stone, Blocks.cobblestone)
				), 
				BiomeCategory.WET
			);
		}
		
		//REDWOOD FOREST
		if(BiomeManager.redwoodforest.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.redwoodforest.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE),
					new TerrainHilly(230f, 120f, 0f),
					new SurfaceMountainStone(BiomeManager.redwoodforest.get().topBlock, BiomeManager.redwoodforest.get().fillerBlock, true, Blocks.sand, 0.2f)
				), 
				BiomeCategory.COLD
			);
		}
		
	    //REDWOOD LUSH
		if(BiomeManager.redwoodlush.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.redwoodlush.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.WET),
					new TerrainHilly(230f, 120f, 0f),
					new SurfaceMountainStone(BiomeManager.redwoodlush.get().topBlock, BiomeManager.redwoodlush.get().fillerBlock, true, Blocks.sand, 0.2f)
				), 
				BiomeCategory.WET
			);
		}
		
	    //SAVANNA
		if(BiomeManager.savanna.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.savanna.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.HOT),
					new TerrainGrasslandFlats(),
					new SurfaceGrasslandMix1(BiomeManager.savanna.get().topBlock, BiomeManager.savanna.get().fillerBlock, Blocks.sand, Blocks.stone, Blocks.cobblestone, 13f, 0.27f)
				), 
				BiomeCategory.HOT
			);
		}
		
		//SHRUBLAND
		if(BiomeManager.shrubland.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.shrubland.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE),
					new TerrainGrasslandHills(90f, 180f, 13f, 100f, 38f, 260f, 71f),
					new SurfaceGrassland(BiomeManager.shrubland.get().topBlock, BiomeManager.shrubland.get().fillerBlock, Blocks.stone, Blocks.cobblestone)
				), 
				BiomeCategory.COLD
			);
		}
		
		//SNOWY FOREST
		if(BiomeManager.snowforest.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.snowforest.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.ICE),
					new TerrainHighland(0f, 140f, 68f, 200f),
					new SurfaceGrassland(BiomeManager.snowforest.get().topBlock, BiomeManager.snowforest.get().fillerBlock, Blocks.stone, Blocks.cobblestone)
				), 
				BiomeCategory.SNOW
			);
		}
		
	    //SNOWY RAIN FOREST
		if(BiomeManager.snowyrainforest.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.snowyrainforest.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.ICE),
					new TerrainHilly(230f, 120f, 0f),
					new SurfaceGrassland(BiomeManager.snowforest.get().topBlock, BiomeManager.snowforest.get().fillerBlock, Blocks.stone, Blocks.cobblestone)
				), 
				BiomeCategory.SNOW
			);
		}
		
	    //TEMPERATE RAINFOREST
		if(BiomeManager.temperaterainforest.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.temperaterainforest.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.WET),
					new TerrainHilly(230f, 120f, 0f),
					new SurfaceMountainStone(BiomeManager.temperaterainforest.get().topBlock, BiomeManager.temperaterainforest.get().fillerBlock, true, Blocks.sand, 0.2f)
				), 
				BiomeCategory.WET
			);
		}
		
	    //TUNDRA
		if(BiomeManager.tundra.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.tundra.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.COLD),
					new TerrainGrasslandHills(90f, 180f, 13f, 100f, 38f, 260f, 71f),
					new SurfaceGrassland(BiomeManager.tundra.get().topBlock, BiomeManager.tundra.get().fillerBlock, Blocks.stone, Blocks.cobblestone)
				), 
				BiomeCategory.COLD
			);
		}
		
		//WASTELAND
		if(BiomeManager.wasteland.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.wasteland.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.OASIS),
					new TerrainGrasslandHills(30f, 180f, 13f, 100f, 28f, 260f, 70f),
					new SurfaceBase[]{
						new SurfaceGrassland(BiomeManager.wasteland.get().topBlock, BiomeManager.wasteland.get().fillerBlock, Blocks.stone, Blocks.cobblestone),
						new SurfaceRiverOasis()
					},
					new EditBase[]{
						new EditRiverOasis()
					}
				), 
				BiomeCategory.HOT
			);
		}
		
		//WOODLANDS
		if(BiomeManager.woodlands.isPresent())
		{
			Support.addBiome(
				new RealisticBiomeSupport(
					BiomeManager.woodlands.get(), VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE),
					new TerrainHighland(0f, 140f, 68f, 200f),
					new SurfaceGrassland(BiomeManager.woodlands.get().topBlock, BiomeManager.woodlands.get().fillerBlock, Blocks.stone, Blocks.cobblestone)
				), 
				BiomeCategory.COLD
			);
		}
		
	}
}
