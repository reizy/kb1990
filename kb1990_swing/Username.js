{
  "cell" : {
    "x" : 52,
    "y" : 22,
    "map" : 0
  },
  "hero" : {
    "@type" : "kb.base.model.Player",
    "army" : [ "ARCHMAGES", "DRAGONS", "ZOMBIES" ],
    "armyCount" : [ 9, 1, 5 ],
    "leadership" : 243,
    "attack" : 1.0,
    "defence" : 1.0,
    "attackSkill" : 0.0,
    "money" : 17629,
    "rank" : 1,
    "name" : "Username",
    "tempLeadership" : 0,
    "tempMovePoints" : 0,
    "spellPower" : 7,
    "spellCapacity" : 13,
    "travelMagicBook" : {
      "spells" : {
        "BridgeSpell" : 2,
        "TimeStopSpell" : 1,
        "FindVillain" : 0,
        "CastleGate" : 0,
        "TownGate" : 0,
        "InstantArmySpell" : 0,
        "RaiseControlSpell" : 1
      }
    },
    "battleMagicBook" : {
      "spells" : {
        "CloneSpell" : 0,
        "TeleportSpell" : 3,
        "FireballSpell" : 0,
        "LightingBoltSpell" : 1,
        "FreezeSpell" : 2,
        "RessurectSpell" : 0,
        "TurnUndeadSpell" : 2
      }
    },
    "commission" : 6109,
    "boatRent" : 500,
    "type" : "SORCERESS",
    "artifacts" : [ {
      "@type" : "kb.base.model.artifact.ArticlesOfNobility",
      "pasleX" : 0,
      "pasleY" : 2
    } ],
    "killedVillains" : [ {
      "@type" : "kb.globalmap.model.villains.Villain",
      "id" : 2,
      "pasleX" : 4,
      "pasleY" : 3,
      "bounty" : 7000,
      "castleCell" : null,
      "army" : [ ],
      "armyCount" : [ ],
      "relocations" : 1,
      "leadership" : 65000,
      "attack" : 1.0,
      "defence" : 1.0,
      "attackSkill" : 0.0,
      "money" : 3300,
      "rank" : 2
    }, {
      "@type" : "kb.globalmap.model.villains.Villain",
      "id" : 0,
      "pasleX" : 3,
      "pasleY" : 4,
      "bounty" : 5000,
      "castleCell" : null,
      "army" : [ ],
      "armyCount" : [ ],
      "relocations" : 1,
      "leadership" : 65000,
      "attack" : 1.0,
      "defence" : 1.0,
      "attackSkill" : 0.0,
      "money" : 1550,
      "rank" : 0
    }, {
      "@type" : "kb.globalmap.model.villains.Villain",
      "id" : 1,
      "pasleX" : 1,
      "pasleY" : 4,
      "bounty" : 6000,
      "castleCell" : null,
      "army" : [ ],
      "armyCount" : [ ],
      "relocations" : 1,
      "leadership" : 65000,
      "attack" : 1.0,
      "defence" : 1.0,
      "attackSkill" : 0.0,
      "money" : 3250,
      "rank" : 1
    } ],
    "contractCell" : {
      "x" : 58,
      "y" : 23,
      "map" : 0
    },
    "magicActive" : true
  },
  "ship" : {
    "cell" : {
      "x" : 52,
      "y" : 22,
      "map" : 0
    }
  },
  "maps" : [ {
    "id" : 0,
    "castles" : [ {
      "cell" : {
        "x" : 58,
        "y" : 23,
        "map" : 0
      },
      "armyHolder" : {
        "@type" : "kb.globalmap.model.villains.Villain",
        "id" : 4,
        "pasleX" : 4,
        "pasleY" : 1,
        "bounty" : 9000,
        "castleCell" : {
          "x" : 58,
          "y" : 23,
          "map" : 0
        },
        "army" : [ "MILITIA", "MILITIA", "ARCHERS", "ELVES", "BARBARIANS" ],
        "armyCount" : [ 60, 50, 10, 10, 5 ],
        "relocations" : 1,
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 6875,
        "rank" : 4
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 57,
        "y" : 58,
        "map" : 0
      },
      "armyHolder" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GNOMES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 300,
        "rank" : 1
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 22,
        "y" : 49,
        "map" : 0
      },
      "armyHolder" : null,
      "isEnemy" : false
    }, {
      "cell" : {
        "x" : 11,
        "y" : 30,
        "map" : 0
      },
      "armyHolder" : {
        "@type" : "kb.globalmap.model.villains.Villain",
        "id" : 3,
        "pasleX" : 0,
        "pasleY" : 3,
        "bounty" : 8000,
        "castleCell" : {
          "x" : 11,
          "y" : 30,
          "map" : 0
        },
        "army" : [ "ORCS", "ARCHERS", "TROLLS", "DWARVES", "WOLVES" ],
        "armyCount" : [ 20, 10, 2, 6, 30 ],
        "relocations" : 1,
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 4650,
        "rank" : 3
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 40,
        "y" : 5,
        "map" : 0
      },
      "armyHolder" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "WOLVES" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 100,
        "rank" : 1
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 54,
        "y" : 6,
        "map" : 0
      },
      "armyHolder" : {
        "@type" : "kb.base.model.ArmyHolder",
        "army" : [ "SKELETONS", "ZOMBIES", "ORCS" ],
        "armyCount" : [ 50, 5, 48 ]
      },
      "isEnemy" : false
    }, {
      "cell" : {
        "x" : 30,
        "y" : 27,
        "map" : 0
      },
      "armyHolder" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ZOMBIES" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 125,
        "rank" : 1
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 6,
        "y" : 57,
        "map" : 0
      },
      "armyHolder" : null,
      "isEnemy" : false
    }, {
      "cell" : {
        "x" : 36,
        "y" : 49,
        "map" : 0
      },
      "armyHolder" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "WOLVES" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 100,
        "rank" : 1
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 40,
        "y" : 41,
        "map" : 0
      },
      "armyHolder" : {
        "@type" : "kb.globalmap.model.villains.Villain",
        "id" : 5,
        "pasleX" : 0,
        "pasleY" : 1,
        "bounty" : 10000,
        "castleCell" : {
          "x" : 40,
          "y" : 41,
          "map" : 0
        },
        "army" : [ "GHOSTS", "SPRITES", "KNIGHTS", "ARCHMAGES", "ARCHMAGES" ],
        "armyCount" : [ 10, 250, 10, 4, 4 ],
        "relocations" : 1,
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 13675,
        "rank" : 5
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 22,
        "y" : 24,
        "map" : 0
      },
      "armyHolder" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GNOMES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 300,
        "rank" : 1
      },
      "isEnemy" : true
    } ],
    "towns" : [ {
      "cell" : {
        "x" : 51,
        "y" : 28,
        "map" : 0
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "InstantArmySpell" ]
    }, {
      "cell" : {
        "x" : 50,
        "y" : 13,
        "map" : 0
      },
      "spell" : [ "kb.base.model.magic.battle.BattleSpells", "FreezeSpell" ]
    }, {
      "cell" : {
        "x" : 46,
        "y" : 35,
        "map" : 0
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "CastleGate" ]
    }, {
      "cell" : {
        "x" : 14,
        "y" : 27,
        "map" : 0
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "TimeStopSpell" ]
    }, {
      "cell" : {
        "x" : 41,
        "y" : 58,
        "map" : 0
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "FindVillain" ]
    }, {
      "cell" : {
        "x" : 17,
        "y" : 21,
        "map" : 0
      },
      "spell" : [ "kb.base.model.magic.battle.BattleSpells", "FireballSpell" ]
    }, {
      "cell" : {
        "x" : 29,
        "y" : 12,
        "map" : 0
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "TownGate" ]
    }, {
      "cell" : {
        "x" : 17,
        "y" : 44,
        "map" : 0
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "RaiseControlSpell" ]
    }, {
      "cell" : {
        "x" : 12,
        "y" : 3,
        "map" : 0
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "TimeStopSpell" ]
    }, {
      "cell" : {
        "x" : 38,
        "y" : 50,
        "map" : 0
      },
      "spell" : [ "kb.base.model.magic.battle.BattleSpells", "TeleportSpell" ]
    }, {
      "cell" : {
        "x" : 57,
        "y" : 5,
        "map" : 0
      },
      "spell" : [ "kb.base.model.magic.battle.BattleSpells", "TurnUndeadSpell" ]
    } ],
    "heroes" : [ {
      "cell" : {
        "x" : 37,
        "y" : 60,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GNOMES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 300,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 18,
        "y" : 12,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ORCS" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 187,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 48,
        "y" : 12,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DWARVES" ],
        "armyCount" : [ 4 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 700,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 54,
        "y" : 8,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "WOLVES" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 100,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 3,
        "y" : 20,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "NOMADS" ],
        "armyCount" : [ 4 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 600,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 26,
        "y" : 6,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "SKELETONS" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 100,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 23,
        "y" : 10,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DWARVES" ],
        "armyCount" : [ 4 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 700,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 16,
        "y" : 58,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GNOMES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 300,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 20,
        "y" : 24,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "SKELETONS" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 100,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 24,
        "y" : 58,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ELVES" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 500,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 32,
        "y" : 17,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "PEASANTS" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 50,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 57,
        "y" : 44,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ORCS" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 187,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 14,
        "y" : 22,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GHOSTS" ],
        "armyCount" : [ 2 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 400,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 7,
        "y" : 17,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ORCS" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 187,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 49,
        "y" : 17,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GNOMES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 300,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 5,
        "y" : 53,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ORCS" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 187,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 53,
        "y" : 59,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "SKELETONS" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 100,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 7,
        "y" : 45,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GNOMES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 300,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 54,
        "y" : 32,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ORCS" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 187,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 33,
        "y" : 6,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "PEASANTS" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 50,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 21,
        "y" : 42,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ZOMBIES" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 125,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 35,
        "y" : 48,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "WOLVES" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 100,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 42,
        "y" : 53,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ORCS" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 187,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 41,
        "y" : 45,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ZOMBIES" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 125,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 31,
        "y" : 39,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DWARVES" ],
        "armyCount" : [ 4 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 700,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 23,
        "y" : 48,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "WOLVES" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 100,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 11,
        "y" : 24,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "WOLVES" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 100,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 43,
        "y" : 12,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DWARVES" ],
        "armyCount" : [ 4 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 700,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 9,
        "y" : 29,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "PEASANTS" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 50,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 54,
        "y" : 37,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ZOMBIES" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 125,
        "rank" : 1
      }
    }, {
      "cell" : {
        "x" : 6,
        "y" : 34,
        "map" : 0
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ZOMBIES" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 125,
        "rank" : 1
      }
    } ],
    "treasures" : [ {
      "@type" : "kb.globalmap.model.treasure.SpellPowerIncreasesTreasure",
      "cell" : {
        "x" : 59,
        "y" : 60,
        "map" : 0
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 11,
        "y" : 22,
        "map" : 0
      },
      "power" : 4
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 49,
        "y" : 45,
        "map" : 0
      },
      "power" : 8
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomUnitTreasure",
      "cell" : {
        "x" : 47,
        "y" : 47,
        "map" : 0
      },
      "power" : 0,
      "unit" : "SKELETONS",
      "count" : 5
    }, {
      "@type" : "kb.globalmap.model.treasure.RichMineralDepositsTreasure",
      "cell" : {
        "x" : 7,
        "y" : 39,
        "map" : 0
      },
      "power" : 15
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 30,
        "y" : 31,
        "map" : 0
      },
      "power" : 8
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 44,
        "y" : 41,
        "map" : 0
      },
      "power" : 6
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellPowerIncreasesTreasure",
      "cell" : {
        "x" : 23,
        "y" : 35,
        "map" : 0
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 8,
        "y" : 58,
        "map" : 0
      },
      "power" : 550,
      "spells" : {
        "FindVillain" : 1,
        "TimeStopSpell" : 1
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.RichMineralDepositsTreasure",
      "cell" : {
        "x" : 31,
        "y" : 36,
        "map" : 0
      },
      "power" : 37
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 3,
        "y" : 15,
        "map" : 0
      },
      "power" : 8
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 59,
        "y" : 57,
        "map" : 0
      },
      "power" : 6
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 37,
        "y" : 7,
        "map" : 0
      },
      "power" : 6
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomUnitTreasure",
      "cell" : {
        "x" : 57,
        "y" : 8,
        "map" : 0
      },
      "power" : 0,
      "unit" : "ZOMBIES",
      "count" : 5
    }, {
      "@type" : "kb.globalmap.model.treasure.FullMapTreasure",
      "cell" : {
        "x" : 21,
        "y" : 13,
        "map" : 0
      },
      "power" : 0
    }, {
      "@type" : "kb.globalmap.model.treasure.ArtifactTreasure",
      "cell" : {
        "x" : 5,
        "y" : 56,
        "map" : 0
      },
      "power" : 0
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomUnitTreasure",
      "cell" : {
        "x" : 23,
        "y" : 17,
        "map" : 0
      },
      "power" : 0,
      "unit" : "NOMADS",
      "count" : 4
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 36,
        "y" : 39,
        "map" : 0
      },
      "power" : 550,
      "spells" : {
        "FireballSpell" : 1
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellCapacityIncreasesTreasure",
      "cell" : {
        "x" : 27,
        "y" : 55,
        "map" : 0
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellCapacityIncreasesTreasure",
      "cell" : {
        "x" : 21,
        "y" : 26,
        "map" : 0
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 23,
        "y" : 57,
        "map" : 0
      },
      "power" : 8
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 59,
        "y" : 33,
        "map" : 0
      },
      "power" : 4
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellPowerIncreasesTreasure",
      "cell" : {
        "x" : 39,
        "y" : 29,
        "map" : 0
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 33,
        "y" : 41,
        "map" : 0
      },
      "power" : 10
    }, {
      "@type" : "kb.globalmap.model.treasure.NextMapTreasure",
      "cell" : {
        "x" : 8,
        "y" : 39,
        "map" : 0
      },
      "power" : 0
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellCapacityIncreasesTreasure",
      "cell" : {
        "x" : 13,
        "y" : 43,
        "map" : 0
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellCapacityIncreasesTreasure",
      "cell" : {
        "x" : 15,
        "y" : 19,
        "map" : 0
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 46,
        "y" : 32,
        "map" : 0
      },
      "power" : 6
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 9,
        "y" : 31,
        "map" : 0
      },
      "power" : 4
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 30,
        "y" : 57,
        "map" : 0
      },
      "power" : 6
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellPowerIncreasesTreasure",
      "cell" : {
        "x" : 57,
        "y" : 40,
        "map" : 0
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.RichMineralDepositsTreasure",
      "cell" : {
        "x" : 35,
        "y" : 20,
        "map" : 0
      },
      "power" : 49
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 17,
        "y" : 34,
        "map" : 0
      },
      "power" : 2
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellPowerIncreasesTreasure",
      "cell" : {
        "x" : 25,
        "y" : 21,
        "map" : 0
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 31,
        "y" : 26,
        "map" : 0
      },
      "power" : 850,
      "spells" : {
        "CloneSpell" : 1
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.RichMineralDepositsTreasure",
      "cell" : {
        "x" : 15,
        "y" : 58,
        "map" : 0
      },
      "power" : 14
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 46,
        "y" : 44,
        "map" : 0
      },
      "power" : 6
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 10,
        "y" : 50,
        "map" : 0
      },
      "power" : 800,
      "spells" : {
        "FireballSpell" : 1,
        "FreezeSpell" : 1
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 40,
        "y" : 49,
        "map" : 0
      },
      "power" : 8
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellCapacityIncreasesTreasure",
      "cell" : {
        "x" : 56,
        "y" : 49,
        "map" : 0
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 36,
        "y" : 60,
        "map" : 0
      },
      "power" : 4
    } ],
    "residence" : [ {
      "unit" : "SPRITES",
      "cell" : {
        "x" : 41,
        "y" : 24,
        "map" : 0
      },
      "count" : 200
    }, {
      "unit" : "SKELETONS",
      "cell" : {
        "x" : 8,
        "y" : 3,
        "map" : 0
      },
      "count" : 100
    }, {
      "unit" : "ELVES",
      "cell" : {
        "x" : 59,
        "y" : 14,
        "map" : 0
      },
      "count" : 100
    }, {
      "unit" : "SKELETONS",
      "cell" : {
        "x" : 54,
        "y" : 40,
        "map" : 0
      },
      "count" : 150
    }, {
      "unit" : "GNOMES",
      "cell" : {
        "x" : 29,
        "y" : 19,
        "map" : 0
      },
      "count" : 250
    }, {
      "unit" : "ELVES",
      "cell" : {
        "x" : 42,
        "y" : 45,
        "map" : 0
      },
      "count" : 100
    }, {
      "unit" : "ORCS",
      "cell" : {
        "x" : 29,
        "y" : 7,
        "map" : 0
      },
      "count" : 200
    }, {
      "unit" : "GNOMES",
      "cell" : {
        "x" : 17,
        "y" : 41,
        "map" : 0
      },
      "count" : 250
    }, {
      "unit" : "GNOMES",
      "cell" : {
        "x" : 3,
        "y" : 4,
        "map" : 0
      },
      "count" : 250
    }, {
      "unit" : "GNOMES",
      "cell" : {
        "x" : 25,
        "y" : 6,
        "map" : 0
      },
      "count" : 250
    }, {
      "unit" : "ORCS",
      "cell" : {
        "x" : 20,
        "y" : 49,
        "map" : 0
      },
      "count" : 200
    }, {
      "unit" : "GNOMES",
      "cell" : {
        "x" : 5,
        "y" : 34,
        "map" : 0
      },
      "count" : 250
    }, {
      "unit" : "TROLLS",
      "cell" : {
        "x" : 27,
        "y" : 11,
        "map" : 0
      },
      "count" : 25
    }, {
      "unit" : "SKELETONS",
      "cell" : {
        "x" : 60,
        "y" : 36,
        "map" : 0
      },
      "count" : 150
    }, {
      "unit" : "DWARVES",
      "cell" : {
        "x" : 48,
        "y" : 30,
        "map" : 0
      },
      "count" : 100
    }, {
      "unit" : "GNOMES",
      "cell" : {
        "x" : 6,
        "y" : 39,
        "map" : 0
      },
      "count" : 250
    }, {
      "unit" : "ORCS",
      "cell" : {
        "x" : 20,
        "y" : 4,
        "map" : 0
      },
      "count" : 152
    }, {
      "unit" : "ELVES",
      "cell" : {
        "x" : 45,
        "y" : 59,
        "map" : 0
      },
      "count" : 100
    }, {
      "unit" : "GNOMES",
      "cell" : {
        "x" : 50,
        "y" : 4,
        "map" : 0
      },
      "count" : 250
    }, {
      "unit" : "PEASANTS",
      "cell" : {
        "x" : 49,
        "y" : 35,
        "map" : 0
      },
      "count" : 250
    }, {
      "unit" : "SKELETONS",
      "cell" : {
        "x" : 49,
        "y" : 7,
        "map" : 0
      },
      "count" : 150
    }, {
      "unit" : "WOLVES",
      "cell" : {
        "x" : 24,
        "y" : 57,
        "map" : 0
      },
      "count" : 100
    } ],
    "unhidden" : [ [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, false, false, false, false, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, false, false, false, false, false, false, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, false, false, false, false, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, false, false, false, false, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, false, false, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, false, false, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, false, false, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, false, false, false, false, false, false, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, false, false, false, false, false, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, false, false, false, false, false, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, false, false, false, false, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, false, false, false, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, false, false, false, false, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, false, false, false, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, true, true, true, true, true, true, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, true, true, true, true, true, true, true, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ] ]
  }, {
    "id" : 1,
    "castles" : [ {
      "cell" : {
        "x" : 25,
        "y" : 39,
        "map" : 1
      },
      "armyHolder" : {
        "@type" : "kb.globalmap.model.villains.Villain",
        "id" : 6,
        "pasleX" : 3,
        "pasleY" : 0,
        "bounty" : 12000,
        "castleCell" : {
          "x" : 25,
          "y" : 39,
          "map" : 1
        },
        "army" : [ "ARCHERS", "PIKEMEN", "MILITIA", "CAVALRY", "KNIGHTS" ],
        "armyCount" : [ 20, 20, 100, 15, 15 ],
        "relocations" : 1,
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 21500,
        "rank" : 6
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 30,
        "y" : 18,
        "map" : 1
      },
      "armyHolder" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DWARVES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1750,
        "rank" : 2
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 41,
        "y" : 34,
        "map" : 1
      },
      "armyHolder" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GNOMES" ],
        "armyCount" : [ 25 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 750,
        "rank" : 2
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 42,
        "y" : 56,
        "map" : 1
      },
      "armyHolder" : {
        "@type" : "kb.globalmap.model.villains.Villain",
        "id" : 8,
        "pasleX" : 3,
        "pasleY" : 3,
        "bounty" : 16000,
        "castleCell" : {
          "x" : 42,
          "y" : 56,
          "map" : 1
        },
        "army" : [ "OGRES", "TROLLS", "GIANTS", "WOLVES", "ORCS" ],
        "armyCount" : [ 20, 10, 5, 80, 150 ],
        "relocations" : 1,
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 24725,
        "rank" : 8
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 19,
        "y" : 19,
        "map" : 1
      },
      "armyHolder" : {
        "@type" : "kb.globalmap.model.villains.Villain",
        "id" : 7,
        "pasleX" : 1,
        "pasleY" : 0,
        "bounty" : 14000,
        "castleCell" : {
          "x" : 19,
          "y" : 19,
          "map" : 1
        },
        "army" : [ "ARCHMAGES", "DRUIDS", "SPRITES", "PIKEMEN", "ELVES" ],
        "armyCount" : [ 30, 10, 300, 35, 30 ],
        "relocations" : 1,
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 32000,
        "rank" : 7
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 47,
        "y" : 6,
        "map" : 1
      },
      "armyHolder" : {
        "@type" : "kb.globalmap.model.villains.Villain",
        "id" : 9,
        "pasleX" : 2,
        "pasleY" : 3,
        "bounty" : 18000,
        "castleCell" : {
          "x" : 47,
          "y" : 6,
          "map" : 1
        },
        "army" : [ "ZOMBIES", "SKELETONS", "GHOSTS", "VAMPIRES", "DEMONS" ],
        "armyCount" : [ 100, 500, 30, 14, 8 ],
        "relocations" : 1,
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 41000,
        "rank" : 9
      },
      "isEnemy" : true
    } ],
    "towns" : [ {
      "cell" : {
        "x" : 58,
        "y" : 4,
        "map" : 1
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "RaiseControlSpell" ]
    }, {
      "cell" : {
        "x" : 58,
        "y" : 60,
        "map" : 1
      },
      "spell" : [ "kb.base.model.magic.battle.BattleSpells", "RessurectSpell" ]
    }, {
      "cell" : {
        "x" : 3,
        "y" : 37,
        "map" : 1
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "TimeStopSpell" ]
    }, {
      "cell" : {
        "x" : 34,
        "y" : 23,
        "map" : 1
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "TimeStopSpell" ]
    }, {
      "cell" : {
        "x" : 58,
        "y" : 33,
        "map" : 1
      },
      "spell" : [ "kb.base.model.magic.battle.BattleSpells", "RessurectSpell" ]
    }, {
      "cell" : {
        "x" : 3,
        "y" : 8,
        "map" : 1
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "InstantArmySpell" ]
    } ],
    "heroes" : [ {
      "cell" : {
        "x" : 10,
        "y" : 40,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "OGRES" ],
        "armyCount" : [ 4 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1500,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 42,
        "y" : 10,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ORCS" ],
        "armyCount" : [ 15 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 562,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 47,
        "y" : 28,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "NOMADS" ],
        "armyCount" : [ 8 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1200,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 21,
        "y" : 45,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ELVES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1000,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 25,
        "y" : 34,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ELVES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1000,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 52,
        "y" : 10,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ELVES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1000,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 15,
        "y" : 59,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "OGRES" ],
        "armyCount" : [ 4 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1500,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 53,
        "y" : 15,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "NOMADS" ],
        "armyCount" : [ 8 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1200,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 13,
        "y" : 15,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DWARVES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1750,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 55,
        "y" : 58,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "WOLVES" ],
        "armyCount" : [ 15 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 300,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 10,
        "y" : 34,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ELVES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1000,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 24,
        "y" : 59,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ELVES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1000,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 8,
        "y" : 57,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "NOMADS" ],
        "armyCount" : [ 8 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1200,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 56,
        "y" : 33,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "BARBARIANS" ],
        "armyCount" : [ 4 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1500,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 33,
        "y" : 55,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ELVES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1000,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 52,
        "y" : 40,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "TROLLS" ],
        "armyCount" : [ 4 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 2000,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 9,
        "y" : 26,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "PEASANTS" ],
        "armyCount" : [ 20 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 100,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 49,
        "y" : 22,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DWARVES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1750,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 4,
        "y" : 46,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "NOMADS" ],
        "armyCount" : [ 8 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1200,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 58,
        "y" : 46,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "TROLLS" ],
        "armyCount" : [ 4 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 2000,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 38,
        "y" : 20,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GNOMES" ],
        "armyCount" : [ 25 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 750,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 9,
        "y" : 15,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "TROLLS" ],
        "armyCount" : [ 4 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 2000,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 41,
        "y" : 32,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "NOMADS" ],
        "armyCount" : [ 8 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1200,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 22,
        "y" : 6,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DWARVES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1750,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 55,
        "y" : 4,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "BARBARIANS" ],
        "armyCount" : [ 4 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1500,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 29,
        "y" : 29,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DWARVES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 1750,
        "rank" : 2
      }
    }, {
      "cell" : {
        "x" : 19,
        "y" : 25,
        "map" : 1
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ZOMBIES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 250,
        "rank" : 2
      }
    } ],
    "treasures" : [ {
      "@type" : "kb.globalmap.model.treasure.SpellPowerIncreasesTreasure",
      "cell" : {
        "x" : 8,
        "y" : 47,
        "map" : 1
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 54,
        "y" : 56,
        "map" : 1
      },
      "power" : 16
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 8,
        "y" : 3,
        "map" : 1
      },
      "power" : 36
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 8,
        "y" : 10,
        "map" : 1
      },
      "power" : 36
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 16,
        "y" : 13,
        "map" : 1
      },
      "power" : 26
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 38,
        "y" : 25,
        "map" : 1
      },
      "power" : 28
    }, {
      "@type" : "kb.globalmap.model.treasure.NextMapTreasure",
      "cell" : {
        "x" : 14,
        "y" : 53,
        "map" : 1
      },
      "power" : 0
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 19,
        "y" : 56,
        "map" : 1
      },
      "power" : 38
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 42,
        "y" : 20,
        "map" : 1
      },
      "power" : 1300,
      "spells" : {
        "BridgeSpell" : 1,
        "LightingBoltSpell" : 1,
        "FireballSpell" : 1
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellCapacityIncreasesTreasure",
      "cell" : {
        "x" : 23,
        "y" : 40,
        "map" : 1
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 3,
        "y" : 3,
        "map" : 1
      },
      "power" : 1700,
      "spells" : {
        "FindVillain" : 2
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellCapacityIncreasesTreasure",
      "cell" : {
        "x" : 50,
        "y" : 3,
        "map" : 1
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.RichMineralDepositsTreasure",
      "cell" : {
        "x" : 19,
        "y" : 21,
        "map" : 1
      },
      "power" : 61
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellPowerIncreasesTreasure",
      "cell" : {
        "x" : 20,
        "y" : 3,
        "map" : 1
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 51,
        "y" : 35,
        "map" : 1
      },
      "power" : 34
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 43,
        "y" : 46,
        "map" : 1
      },
      "power" : 1350,
      "spells" : {
        "TimeStopSpell" : 1,
        "FireballSpell" : 1,
        "TownGate" : 1
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellPowerIncreasesTreasure",
      "cell" : {
        "x" : 12,
        "y" : 27,
        "map" : 1
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellCapacityIncreasesTreasure",
      "cell" : {
        "x" : 41,
        "y" : 3,
        "map" : 1
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellCapacityIncreasesTreasure",
      "cell" : {
        "x" : 53,
        "y" : 29,
        "map" : 1
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 43,
        "y" : 12,
        "map" : 1
      },
      "power" : 24
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 35,
        "y" : 13,
        "map" : 1
      },
      "power" : 38
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 43,
        "y" : 47,
        "map" : 1
      },
      "power" : 1250,
      "spells" : {
        "FindVillain" : 1,
        "TeleportSpell" : 1
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.RichMineralDepositsTreasure",
      "cell" : {
        "x" : 43,
        "y" : 26,
        "map" : 1
      },
      "power" : 66
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 40,
        "y" : 46,
        "map" : 1
      },
      "power" : 2350,
      "spells" : {
        "BridgeSpell" : 1,
        "RessurectSpell" : 1,
        "RaiseControlSpell" : 1
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.RichMineralDepositsTreasure",
      "cell" : {
        "x" : 27,
        "y" : 46,
        "map" : 1
      },
      "power" : 77
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 29,
        "y" : 56,
        "map" : 1
      },
      "power" : 26
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 37,
        "y" : 38,
        "map" : 1
      },
      "power" : 2050,
      "spells" : {
        "TimeStopSpell" : 6,
        "RaiseControlSpell" : 1,
        "TownGate" : 1
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomUnitTreasure",
      "cell" : {
        "x" : 53,
        "y" : 6,
        "map" : 1
      },
      "power" : 1,
      "unit" : "ELVES",
      "count" : 10
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 16,
        "y" : 46,
        "map" : 1
      },
      "power" : 16
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellPowerIncreasesTreasure",
      "cell" : {
        "x" : 16,
        "y" : 40,
        "map" : 1
      },
      "power" : 2
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 11,
        "y" : 11,
        "map" : 1
      },
      "power" : 34
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomUnitTreasure",
      "cell" : {
        "x" : 38,
        "y" : 47,
        "map" : 1
      },
      "power" : 1,
      "unit" : "NOMADS",
      "count" : 8
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 43,
        "y" : 45,
        "map" : 1
      },
      "power" : 2050,
      "spells" : {
        "RessurectSpell" : 1,
        "TeleportSpell" : 1,
        "FireballSpell" : 1
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.FullMapTreasure",
      "cell" : {
        "x" : 35,
        "y" : 30,
        "map" : 1
      },
      "power" : 0
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 39,
        "y" : 13,
        "map" : 1
      },
      "power" : 26
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 56,
        "y" : 9,
        "map" : 1
      },
      "power" : 16
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellCapacityIncreasesTreasure",
      "cell" : {
        "x" : 32,
        "y" : 54,
        "map" : 1
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.ArtifactTreasure",
      "cell" : {
        "x" : 8,
        "y" : 13,
        "map" : 1
      },
      "power" : 2
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 50,
        "y" : 52,
        "map" : 1
      },
      "power" : 1750,
      "spells" : {
        "TurnUndeadSpell" : 1
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.ArtifactTreasure",
      "cell" : {
        "x" : 36,
        "y" : 55,
        "map" : 1
      },
      "power" : 3
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 60,
        "y" : 29,
        "map" : 1
      },
      "power" : 2150,
      "spells" : {
        "FindVillain" : 1,
        "CloneSpell" : 1,
        "TeleportSpell" : 1
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 12,
        "y" : 11,
        "map" : 1
      },
      "power" : 24
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomUnitTreasure",
      "cell" : {
        "x" : 21,
        "y" : 31,
        "map" : 1
      },
      "power" : 1,
      "unit" : "OGRES",
      "count" : 4
    } ],
    "residence" : [ {
      "unit" : "NOMADS",
      "cell" : {
        "x" : 46,
        "y" : 58,
        "map" : 1
      },
      "count" : 100
    }, {
      "unit" : "ELVES",
      "cell" : {
        "x" : 59,
        "y" : 7,
        "map" : 1
      },
      "count" : 100
    }, {
      "unit" : "ELVES",
      "cell" : {
        "x" : 46,
        "y" : 23,
        "map" : 1
      },
      "count" : 100
    }, {
      "unit" : "ELVES",
      "cell" : {
        "x" : 11,
        "y" : 19,
        "map" : 1
      },
      "count" : 100
    }, {
      "unit" : "OGRES",
      "cell" : {
        "x" : 32,
        "y" : 55,
        "map" : 1
      },
      "count" : 200
    }, {
      "unit" : "DWARVES",
      "cell" : {
        "x" : 57,
        "y" : 54,
        "map" : 1
      },
      "count" : 100
    }, {
      "unit" : "NOMADS",
      "cell" : {
        "x" : 12,
        "y" : 19,
        "map" : 1
      },
      "count" : 100
    }, {
      "unit" : "ZOMBIES",
      "cell" : {
        "x" : 15,
        "y" : 26,
        "map" : 1
      },
      "count" : 100
    }, {
      "unit" : "DWARVES",
      "cell" : {
        "x" : 44,
        "y" : 15,
        "map" : 1
      },
      "count" : 100
    }, {
      "unit" : "ORCS",
      "cell" : {
        "x" : 14,
        "y" : 46,
        "map" : 1
      },
      "count" : 200
    }, {
      "unit" : "GNOMES",
      "cell" : {
        "x" : 51,
        "y" : 49,
        "map" : 1
      },
      "count" : 250
    }, {
      "unit" : "DWARVES",
      "cell" : {
        "x" : 11,
        "y" : 51,
        "map" : 1
      },
      "count" : 100
    }, {
      "unit" : "ZOMBIES",
      "cell" : {
        "x" : 54,
        "y" : 19,
        "map" : 1
      },
      "count" : 100
    }, {
      "unit" : "BARBARIANS",
      "cell" : {
        "x" : 24,
        "y" : 18,
        "map" : 1
      },
      "count" : 100
    }, {
      "unit" : "ORCS",
      "cell" : {
        "x" : 31,
        "y" : 4,
        "map" : 1
      },
      "count" : 200
    }, {
      "unit" : "ELVES",
      "cell" : {
        "x" : 45,
        "y" : 7,
        "map" : 1
      },
      "count" : 100
    }, {
      "unit" : "GHOSTS",
      "cell" : {
        "x" : 59,
        "y" : 18,
        "map" : 1
      },
      "count" : 25
    }, {
      "unit" : "ELVES",
      "cell" : {
        "x" : 15,
        "y" : 46,
        "map" : 1
      },
      "count" : 100
    }, {
      "unit" : "GNOMES",
      "cell" : {
        "x" : 11,
        "y" : 37,
        "map" : 1
      },
      "count" : 250
    }, {
      "unit" : "DWARVES",
      "cell" : {
        "x" : 27,
        "y" : 31,
        "map" : 1
      },
      "count" : 100
    }, {
      "unit" : "ZOMBIES",
      "cell" : {
        "x" : 60,
        "y" : 27,
        "map" : 1
      },
      "count" : 100
    }, {
      "unit" : "GHOSTS",
      "cell" : {
        "x" : 47,
        "y" : 31,
        "map" : 1
      },
      "count" : 25
    } ],
    "unhidden" : [ [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ] ]
  }, {
    "id" : 2,
    "castles" : [ {
      "cell" : {
        "x" : 52,
        "y" : 57,
        "map" : 2
      },
      "armyHolder" : {
        "@type" : "kb.globalmap.model.villains.Villain",
        "id" : 12,
        "pasleX" : 1,
        "pasleY" : 2,
        "bounty" : 30000,
        "castleCell" : {
          "x" : 52,
          "y" : 57,
          "map" : 2
        },
        "army" : [ "BARBARIANS", "GIANTS", "GNOMES", "NOMADS", "PEASANTS" ],
        "armyCount" : [ 45, 20, 300, 100, 750 ],
        "relocations" : 1,
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 64625,
        "rank" : 12
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 43,
        "y" : 27,
        "map" : 2
      },
      "armyHolder" : {
        "@type" : "kb.globalmap.model.villains.Villain",
        "id" : 13,
        "pasleX" : 3,
        "pasleY" : 1,
        "bounty" : 35000,
        "castleCell" : {
          "x" : 43,
          "y" : 27,
          "map" : 2
        },
        "army" : [ "PIKEMEN", "ARCHERS", "CAVALRY", "KNIGHTS", "DRAGONS" ],
        "armyCount" : [ 110, 45, 85, 60, 5 ],
        "relocations" : 1,
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 98625,
        "rank" : 13
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 9,
        "y" : 18,
        "map" : 2
      },
      "armyHolder" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "VAMPIRES" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 7500,
        "rank" : 3
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 45,
        "y" : 6,
        "map" : 2
      },
      "armyHolder" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GIANTS" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 5000,
        "rank" : 3
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 41,
        "y" : 36,
        "map" : 2
      },
      "armyHolder" : {
        "@type" : "kb.globalmap.model.villains.Villain",
        "id" : 11,
        "pasleX" : 3,
        "pasleY" : 2,
        "bounty" : 25000,
        "castleCell" : {
          "x" : 41,
          "y" : 36,
          "map" : 2
        },
        "army" : [ "DRAGONS", "GIANTS", "OGRES", "ORCS", "GNOMES" ],
        "armyCount" : [ 5, 30, 30, 200, 200 ],
        "relocations" : 1,
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 67250,
        "rank" : 11
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 11,
        "y" : 46,
        "map" : 2
      },
      "armyHolder" : {
        "@type" : "kb.globalmap.model.villains.Villain",
        "id" : 10,
        "pasleX" : 1,
        "pasleY" : 3,
        "bounty" : 20000,
        "castleCell" : {
          "x" : 11,
          "y" : 46,
          "map" : 2
        },
        "army" : [ "ZOMBIES", "SKELETONS", "GHOSTS", "VAMPIRES", "DEMONS" ],
        "armyCount" : [ 220, 640, 50, 30, 10 ],
        "relocations" : 1,
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 65800,
        "rank" : 10
      },
      "isEnemy" : true
    } ],
    "towns" : [ {
      "cell" : {
        "x" : 5,
        "y" : 50,
        "map" : 2
      },
      "spell" : [ "kb.base.model.magic.battle.BattleSpells", "CloneSpell" ]
    }, {
      "cell" : {
        "x" : 49,
        "y" : 8,
        "map" : 2
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "BridgeSpell" ]
    }, {
      "cell" : {
        "x" : 13,
        "y" : 60,
        "map" : 2
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "TimeStopSpell" ]
    }, {
      "cell" : {
        "x" : 13,
        "y" : 7,
        "map" : 2
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "RaiseControlSpell" ]
    }, {
      "cell" : {
        "x" : 9,
        "y" : 39,
        "map" : 2
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "CastleGate" ]
    }, {
      "cell" : {
        "x" : 57,
        "y" : 57,
        "map" : 2
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "BridgeSpell" ]
    } ],
    "heroes" : [ {
      "cell" : {
        "x" : 52,
        "y" : 55,
        "map" : 2
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "TROLLS" ],
        "armyCount" : [ 8 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 4000,
        "rank" : 3
      }
    }, {
      "cell" : {
        "x" : 45,
        "y" : 42,
        "map" : 2
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "OGRES" ],
        "armyCount" : [ 8 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 3000,
        "rank" : 3
      }
    }, {
      "cell" : {
        "x" : 17,
        "y" : 10,
        "map" : 2
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DRUIDS" ],
        "armyCount" : [ 6 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 2100,
        "rank" : 3
      }
    }, {
      "cell" : {
        "x" : 11,
        "y" : 15,
        "map" : 2
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GIANTS" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 5000,
        "rank" : 3
      }
    }, {
      "cell" : {
        "x" : 9,
        "y" : 37,
        "map" : 2
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "BARBARIANS" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 3750,
        "rank" : 3
      }
    }, {
      "cell" : {
        "x" : 42,
        "y" : 26,
        "map" : 2
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GHOSTS" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 2000,
        "rank" : 3
      }
    }, {
      "cell" : {
        "x" : 11,
        "y" : 44,
        "map" : 2
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ELVES" ],
        "armyCount" : [ 25 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 2500,
        "rank" : 3
      }
    }, {
      "cell" : {
        "x" : 7,
        "y" : 49,
        "map" : 2
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GHOSTS" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 2000,
        "rank" : 3
      }
    }, {
      "cell" : {
        "x" : 43,
        "y" : 5,
        "map" : 2
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GIANTS" ],
        "armyCount" : [ 5 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 5000,
        "rank" : 3
      }
    }, {
      "cell" : {
        "x" : 41,
        "y" : 34,
        "map" : 2
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "TROLLS" ],
        "armyCount" : [ 8 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 4000,
        "rank" : 3
      }
    } ],
    "treasures" : [ {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 7,
        "y" : 57,
        "map" : 2
      },
      "power" : 56
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 51,
        "y" : 42,
        "map" : 2
      },
      "power" : 32
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 8,
        "y" : 42,
        "map" : 2
      },
      "power" : 2300,
      "spells" : {
        "TurnUndeadSpell" : 1,
        "LightingBoltSpell" : 1,
        "FreezeSpell" : 1
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellCapacityIncreasesTreasure",
      "cell" : {
        "x" : 13,
        "y" : 11,
        "map" : 2
      },
      "power" : 2
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 38,
        "y" : 57,
        "map" : 2
      },
      "power" : 52
    }, {
      "@type" : "kb.globalmap.model.treasure.ArtifactTreasure",
      "cell" : {
        "x" : 45,
        "y" : 28,
        "map" : 2
      },
      "power" : 5
    }, {
      "@type" : "kb.globalmap.model.treasure.NextMapTreasure",
      "cell" : {
        "x" : 8,
        "y" : 30,
        "map" : 2
      },
      "power" : 0
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 37,
        "y" : 44,
        "map" : 2
      },
      "power" : 60
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 5,
        "y" : 14,
        "map" : 2
      },
      "power" : 36
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellCapacityIncreasesTreasure",
      "cell" : {
        "x" : 40,
        "y" : 10,
        "map" : 2
      },
      "power" : 1
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 30,
        "y" : 20,
        "map" : 2
      },
      "power" : 40
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 46,
        "y" : 44,
        "map" : 2
      },
      "power" : 2050,
      "spells" : {
        "BridgeSpell" : 1,
        "InstantArmySpell" : 2
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 25,
        "y" : 21,
        "map" : 2
      },
      "power" : 50
    }, {
      "@type" : "kb.globalmap.model.treasure.ArtifactTreasure",
      "cell" : {
        "x" : 34,
        "y" : 32,
        "map" : 2
      },
      "power" : 4
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 32,
        "y" : 56,
        "map" : 2
      },
      "power" : 62
    }, {
      "@type" : "kb.globalmap.model.treasure.FullMapTreasure",
      "cell" : {
        "x" : 31,
        "y" : 4,
        "map" : 2
      },
      "power" : 0
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 37,
        "y" : 45,
        "map" : 2
      },
      "power" : 58
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 38,
        "y" : 21,
        "map" : 2
      },
      "power" : 3100,
      "spells" : {
        "FindVillain" : 2,
        "InstantArmySpell" : 1,
        "TownGate" : 1
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 44,
        "y" : 10,
        "map" : 2
      },
      "power" : 28
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 34,
        "y" : 3,
        "map" : 2
      },
      "power" : 50
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 5,
        "y" : 17,
        "map" : 2
      },
      "power" : 58
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 45,
        "y" : 45,
        "map" : 2
      },
      "power" : 36
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 46,
        "y" : 55,
        "map" : 2
      },
      "power" : 3700,
      "spells" : {
        "TurnUndeadSpell" : 1,
        "LightingBoltSpell" : 2,
        "TeleportSpell" : 2
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 11,
        "y" : 59,
        "map" : 2
      },
      "power" : 64
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 29,
        "y" : 27,
        "map" : 2
      },
      "power" : 38
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 8,
        "y" : 57,
        "map" : 2
      },
      "power" : 68
    } ],
    "residence" : [ {
      "unit" : "ARCHMAGES",
      "cell" : {
        "x" : 53,
        "y" : 23,
        "map" : 2
      },
      "count" : 25
    }, {
      "unit" : "GHOSTS",
      "cell" : {
        "x" : 30,
        "y" : 44,
        "map" : 2
      },
      "count" : 25
    }, {
      "unit" : "GHOSTS",
      "cell" : {
        "x" : 6,
        "y" : 48,
        "map" : 2
      },
      "count" : 25
    }, {
      "unit" : "TROLLS",
      "cell" : {
        "x" : 8,
        "y" : 39,
        "map" : 2
      },
      "count" : 25
    }, {
      "unit" : "DWARVES",
      "cell" : {
        "x" : 30,
        "y" : 22,
        "map" : 2
      },
      "count" : 100
    }, {
      "unit" : "DEMONS",
      "cell" : {
        "x" : 13,
        "y" : 35,
        "map" : 2
      },
      "count" : 25
    }, {
      "unit" : "GHOSTS",
      "cell" : {
        "x" : 53,
        "y" : 25,
        "map" : 2
      },
      "count" : 25
    }, {
      "unit" : "BARBARIANS",
      "cell" : {
        "x" : 20,
        "y" : 6,
        "map" : 2
      },
      "count" : 100
    }, {
      "unit" : "OGRES",
      "cell" : {
        "x" : 51,
        "y" : 40,
        "map" : 2
      },
      "count" : 200
    }, {
      "unit" : "GHOSTS",
      "cell" : {
        "x" : 3,
        "y" : 31,
        "map" : 2
      },
      "count" : 25
    }, {
      "unit" : "ARCHMAGES",
      "cell" : {
        "x" : 47,
        "y" : 27,
        "map" : 2
      },
      "count" : 25
    }, {
      "unit" : "GHOSTS",
      "cell" : {
        "x" : 25,
        "y" : 23,
        "map" : 2
      },
      "count" : 25
    }, {
      "unit" : "ARCHMAGES",
      "cell" : {
        "x" : 10,
        "y" : 9,
        "map" : 2
      },
      "count" : 25
    }, {
      "unit" : "GHOSTS",
      "cell" : {
        "x" : 34,
        "y" : 30,
        "map" : 2
      },
      "count" : 25
    }, {
      "unit" : "GHOSTS",
      "cell" : {
        "x" : 15,
        "y" : 33,
        "map" : 2
      },
      "count" : 25
    }, {
      "unit" : "TROLLS",
      "cell" : {
        "x" : 32,
        "y" : 44,
        "map" : 2
      },
      "count" : 25
    }, {
      "unit" : "TROLLS",
      "cell" : {
        "x" : 33,
        "y" : 39,
        "map" : 2
      },
      "count" : 25
    }, {
      "unit" : "ELVES",
      "cell" : {
        "x" : 37,
        "y" : 43,
        "map" : 2
      },
      "count" : 100
    }, {
      "unit" : "ELVES",
      "cell" : {
        "x" : 37,
        "y" : 24,
        "map" : 2
      },
      "count" : 100
    } ],
    "unhidden" : [ [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ] ]
  }, {
    "id" : 3,
    "castles" : [ {
      "cell" : {
        "x" : 41,
        "y" : 12,
        "map" : 3
      },
      "armyHolder" : {
        "@type" : "kb.globalmap.model.villains.Villain",
        "id" : 15,
        "pasleX" : 1,
        "pasleY" : 1,
        "bounty" : 45000,
        "castleCell" : {
          "x" : 41,
          "y" : 12,
          "map" : 3
        },
        "army" : [ "DRAGONS", "CAVALRY", "DEMONS", "KNIGHTS", "ARCHMAGES" ],
        "armyCount" : [ 10, 200, 50, 250, 60 ],
        "relocations" : 1,
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 341000,
        "rank" : 15
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 46,
        "y" : 43,
        "map" : 3
      },
      "armyHolder" : {
        "@type" : "kb.globalmap.model.villains.Villain",
        "id" : 14,
        "pasleX" : 2,
        "pasleY" : 1,
        "bounty" : 40000,
        "castleCell" : {
          "x" : 46,
          "y" : 43,
          "map" : 3
        },
        "army" : [ "VAMPIRES", "ARCHMAGES", "DEMONS", "GNOMES", "PEASANTS" ],
        "armyCount" : [ 60, 100, 30, 500, 5000 ],
        "relocations" : 1,
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 190000,
        "rank" : 14
      },
      "isEnemy" : true
    }, {
      "cell" : {
        "x" : 17,
        "y" : 39,
        "map" : 3
      },
      "armyHolder" : {
        "@type" : "kb.globalmap.model.villains.Villain",
        "id" : 16,
        "pasleX" : 2,
        "pasleY" : 2,
        "bounty" : 50000,
        "castleCell" : {
          "x" : 17,
          "y" : 39,
          "map" : 3
        },
        "army" : [ "DRAGONS", "DRAGONS", "DRAGONS", "DEMONS", "VAMPIRES" ],
        "armyCount" : [ 23, 24, 100, 100, 100 ],
        "relocations" : 1,
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 592500,
        "rank" : 16
      },
      "isEnemy" : true
    } ],
    "towns" : [ {
      "cell" : {
        "x" : 9,
        "y" : 60,
        "map" : 3
      },
      "spell" : [ "kb.base.model.magic.globalmap.TravelSpells", "RaiseControlSpell" ]
    }, {
      "cell" : {
        "x" : 7,
        "y" : 3,
        "map" : 3
      },
      "spell" : [ "kb.base.model.magic.battle.BattleSpells", "TeleportSpell" ]
    }, {
      "cell" : {
        "x" : 58,
        "y" : 48,
        "map" : 3
      },
      "spell" : [ "kb.base.model.magic.battle.BattleSpells", "FireballSpell" ]
    } ],
    "heroes" : [ {
      "cell" : {
        "x" : 28,
        "y" : 38,
        "map" : 3
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GIANTS" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 10000,
        "rank" : 4
      }
    }, {
      "cell" : {
        "x" : 38,
        "y" : 30,
        "map" : 3
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DRUIDS" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 3500,
        "rank" : 4
      }
    }, {
      "cell" : {
        "x" : 3,
        "y" : 35,
        "map" : 3
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "OGRES" ],
        "armyCount" : [ 15 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 5625,
        "rank" : 4
      }
    }, {
      "cell" : {
        "x" : 25,
        "y" : 24,
        "map" : 3
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DEMONS" ],
        "armyCount" : [ 8 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 12000,
        "rank" : 4
      }
    }, {
      "cell" : {
        "x" : 35,
        "y" : 24,
        "map" : 3
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ARCHMAGES" ],
        "armyCount" : [ 8 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 4800,
        "rank" : 4
      }
    }, {
      "cell" : {
        "x" : 43,
        "y" : 48,
        "map" : 3
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DRUIDS" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 3500,
        "rank" : 4
      }
    }, {
      "cell" : {
        "x" : 59,
        "y" : 47,
        "map" : 3
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DRUIDS" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 3500,
        "rank" : 4
      }
    }, {
      "cell" : {
        "x" : 59,
        "y" : 4,
        "map" : 3
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DEMONS" ],
        "armyCount" : [ 8 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 12000,
        "rank" : 4
      }
    }, {
      "cell" : {
        "x" : 60,
        "y" : 32,
        "map" : 3
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DRAGONS" ],
        "armyCount" : [ 2 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 5000,
        "rank" : 4
      }
    }, {
      "cell" : {
        "x" : 6,
        "y" : 4,
        "map" : 3
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "VAMPIRES" ],
        "armyCount" : [ 25 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 18750,
        "rank" : 4
      }
    }, {
      "cell" : {
        "x" : 34,
        "y" : 40,
        "map" : 3
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "ARCHMAGES" ],
        "armyCount" : [ 8 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 4800,
        "rank" : 4
      }
    }, {
      "cell" : {
        "x" : 59,
        "y" : 59,
        "map" : 3
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GIANTS" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 10000,
        "rank" : 4
      }
    }, {
      "cell" : {
        "x" : 31,
        "y" : 27,
        "map" : 3
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GIANTS" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 10000,
        "rank" : 4
      }
    }, {
      "cell" : {
        "x" : 8,
        "y" : 59,
        "map" : 3
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "GHOSTS" ],
        "armyCount" : [ 20 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 4000,
        "rank" : 4
      }
    }, {
      "cell" : {
        "x" : 33,
        "y" : 49,
        "map" : 3
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DEMONS" ],
        "armyCount" : [ 8 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 12000,
        "rank" : 4
      }
    }, {
      "cell" : {
        "x" : 5,
        "y" : 19,
        "map" : 3
      },
      "hero" : {
        "@type" : "kb.base.model.Hero",
        "army" : [ "DRUIDS" ],
        "armyCount" : [ 10 ],
        "leadership" : 65000,
        "attack" : 1.0,
        "defence" : 1.0,
        "attackSkill" : 0.0,
        "money" : 3500,
        "rank" : 4
      }
    } ],
    "treasures" : [ {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 30,
        "y" : 45,
        "map" : 3
      },
      "power" : 66
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 18,
        "y" : 23,
        "map" : 3
      },
      "power" : 58
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellPowerIncreasesTreasure",
      "cell" : {
        "x" : 32,
        "y" : 39,
        "map" : 3
      },
      "power" : 2
    }, {
      "@type" : "kb.globalmap.model.treasure.ArtifactTreasure",
      "cell" : {
        "x" : 18,
        "y" : 27,
        "map" : 3
      },
      "power" : 6
    }, {
      "@type" : "kb.globalmap.model.treasure.ArtifactTreasure",
      "cell" : {
        "x" : 33,
        "y" : 45,
        "map" : 3
      },
      "power" : 7
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 30,
        "y" : 32,
        "map" : 3
      },
      "power" : 48
    }, {
      "@type" : "kb.globalmap.model.treasure.RichMineralDepositsTreasure",
      "cell" : {
        "x" : 42,
        "y" : 45,
        "map" : 3
      },
      "power" : 286
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 31,
        "y" : 33,
        "map" : 3
      },
      "power" : 56
    }, {
      "@type" : "kb.globalmap.model.treasure.RichMineralDepositsTreasure",
      "cell" : {
        "x" : 36,
        "y" : 26,
        "map" : 3
      },
      "power" : 228
    }, {
      "@type" : "kb.globalmap.model.treasure.FullMapTreasure",
      "cell" : {
        "x" : 13,
        "y" : 12,
        "map" : 3
      },
      "power" : 0
    }, {
      "@type" : "kb.globalmap.model.treasure.RichMineralDepositsTreasure",
      "cell" : {
        "x" : 33,
        "y" : 33,
        "map" : 3
      },
      "power" : 299
    }, {
      "@type" : "kb.globalmap.model.treasure.NextMapTreasure",
      "cell" : {
        "x" : 28,
        "y" : 45,
        "map" : 3
      },
      "power" : 0
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 30,
        "y" : 26,
        "map" : 3
      },
      "power" : 90
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomUnitTreasure",
      "cell" : {
        "x" : 46,
        "y" : 48,
        "map" : 3
      },
      "power" : 3,
      "unit" : "DRUIDS",
      "count" : 10
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellCapacityIncreasesTreasure",
      "cell" : {
        "x" : 42,
        "y" : 11,
        "map" : 3
      },
      "power" : 2
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 45,
        "y" : 26,
        "map" : 3
      },
      "power" : 60
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellPowerIncreasesTreasure",
      "cell" : {
        "x" : 42,
        "y" : 24,
        "map" : 3
      },
      "power" : 2
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 49,
        "y" : 41,
        "map" : 3
      },
      "power" : 42
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 15,
        "y" : 40,
        "map" : 3
      },
      "power" : 92
    }, {
      "@type" : "kb.globalmap.model.treasure.RichMineralDepositsTreasure",
      "cell" : {
        "x" : 51,
        "y" : 9,
        "map" : 3
      },
      "power" : 297
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 13,
        "y" : 30,
        "map" : 3
      },
      "power" : 78
    }, {
      "@type" : "kb.globalmap.model.treasure.RichMineralDepositsTreasure",
      "cell" : {
        "x" : 34,
        "y" : 45,
        "map" : 3
      },
      "power" : 205
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 39,
        "y" : 32,
        "map" : 3
      },
      "power" : 86
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 33,
        "y" : 23,
        "map" : 3
      },
      "power" : 52
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 10,
        "y" : 28,
        "map" : 3
      },
      "power" : 54
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomSpellTreasure",
      "cell" : {
        "x" : 29,
        "y" : 45,
        "map" : 3
      },
      "power" : 2800,
      "spells" : {
        "CloneSpell" : 2
      }
    }, {
      "@type" : "kb.globalmap.model.treasure.SpellCapacityIncreasesTreasure",
      "cell" : {
        "x" : 29,
        "y" : 39,
        "map" : 3
      },
      "power" : 3
    }, {
      "@type" : "kb.globalmap.model.treasure.RichMineralDepositsTreasure",
      "cell" : {
        "x" : 27,
        "y" : 30,
        "map" : 3
      },
      "power" : 178
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomUnitTreasure",
      "cell" : {
        "x" : 27,
        "y" : 23,
        "map" : 3
      },
      "power" : 3,
      "unit" : "GIANTS",
      "count" : 10
    }, {
      "@type" : "kb.globalmap.model.treasure.RandomUnitTreasure",
      "cell" : {
        "x" : 27,
        "y" : 26,
        "map" : 3
      },
      "power" : 3,
      "unit" : "GHOSTS",
      "count" : 20
    }, {
      "@type" : "kb.globalmap.model.treasure.RichMineralDepositsTreasure",
      "cell" : {
        "x" : 27,
        "y" : 36,
        "map" : 3
      },
      "power" : 181
    }, {
      "@type" : "kb.globalmap.model.treasure.GoldTreasure",
      "cell" : {
        "x" : 22,
        "y" : 45,
        "map" : 3
      },
      "power" : 50
    } ],
    "residence" : [ {
      "unit" : "ARCHMAGES",
      "cell" : {
        "x" : 50,
        "y" : 46,
        "map" : 3
      },
      "count" : 25
    }, {
      "unit" : "DRUIDS",
      "cell" : {
        "x" : 36,
        "y" : 20,
        "map" : 3
      },
      "count" : 25
    }, {
      "unit" : "VAMPIRES",
      "cell" : {
        "x" : 27,
        "y" : 33,
        "map" : 3
      },
      "count" : 50
    }, {
      "unit" : "ARCHMAGES",
      "cell" : {
        "x" : 42,
        "y" : 28,
        "map" : 3
      },
      "count" : 25
    }, {
      "unit" : "GHOSTS",
      "cell" : {
        "x" : 32,
        "y" : 20,
        "map" : 3
      },
      "count" : 25
    }, {
      "unit" : "ARCHMAGES",
      "cell" : {
        "x" : 27,
        "y" : 20,
        "map" : 3
      },
      "count" : 25
    }, {
      "unit" : "GIANTS",
      "cell" : {
        "x" : 27,
        "y" : 50,
        "map" : 3
      },
      "count" : 50
    }, {
      "unit" : "ARCHMAGES",
      "cell" : {
        "x" : 42,
        "y" : 37,
        "map" : 3
      },
      "count" : 25
    }, {
      "unit" : "OGRES",
      "cell" : {
        "x" : 18,
        "y" : 44,
        "map" : 3
      },
      "count" : 200
    }, {
      "unit" : "NOMADS",
      "cell" : {
        "x" : 30,
        "y" : 23,
        "map" : 3
      },
      "count" : 100
    }, {
      "unit" : "DRAGONS",
      "cell" : {
        "x" : 35,
        "y" : 45,
        "map" : 3
      },
      "count" : 25
    }, {
      "unit" : "BARBARIANS",
      "cell" : {
        "x" : 11,
        "y" : 52,
        "map" : 3
      },
      "count" : 100
    }, {
      "unit" : "BARBARIANS",
      "cell" : {
        "x" : 18,
        "y" : 34,
        "map" : 3
      },
      "count" : 100
    }, {
      "unit" : "GIANTS",
      "cell" : {
        "x" : 18,
        "y" : 43,
        "map" : 3
      },
      "count" : 50
    }, {
      "unit" : "ARCHMAGES",
      "cell" : {
        "x" : 36,
        "y" : 29,
        "map" : 3
      },
      "count" : 25
    }, {
      "unit" : "ARCHMAGES",
      "cell" : {
        "x" : 23,
        "y" : 19,
        "map" : 3
      },
      "count" : 25
    }, {
      "unit" : "GHOSTS",
      "cell" : {
        "x" : 44,
        "y" : 34,
        "map" : 3
      },
      "count" : 25
    }, {
      "unit" : "GIANTS",
      "cell" : {
        "x" : 43,
        "y" : 32,
        "map" : 3
      },
      "count" : 50
    }, {
      "unit" : "VAMPIRES",
      "cell" : {
        "x" : 39,
        "y" : 35,
        "map" : 3
      },
      "count" : 50
    }, {
      "unit" : "OGRES",
      "cell" : {
        "x" : 23,
        "y" : 45,
        "map" : 3
      },
      "count" : 200
    }, {
      "unit" : "GIANTS",
      "cell" : {
        "x" : 29,
        "y" : 50,
        "map" : 3
      },
      "count" : 50
    }, {
      "unit" : "DRAGONS",
      "cell" : {
        "x" : 20,
        "y" : 19,
        "map" : 3
      },
      "count" : 25
    } ],
    "unhidden" : [ [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ], [ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ] ]
  } ],
  "openedMaps" : [ 0 ],
  "fullMaps" : [ ],
  "avaibleTowns" : [ {
    "x" : 51,
    "y" : 28,
    "map" : 0
  }, {
    "x" : 12,
    "y" : 3,
    "map" : 0
  }, {
    "x" : 57,
    "y" : 5,
    "map" : 0
  } ],
  "avaibleCastles" : [ {
    "x" : 22,
    "y" : 49,
    "map" : 0
  }, {
    "x" : 57,
    "y" : 58,
    "map" : 0
  }, {
    "x" : 58,
    "y" : 23,
    "map" : 0
  }, {
    "x" : 40,
    "y" : 5,
    "map" : 0
  }, {
    "x" : 54,
    "y" : 6,
    "map" : 0
  } ],
  "pasleAimCell" : {
    "x" : 50,
    "y" : 35,
    "map" : 2
  },
  "time" : 23767,
  "maxWeek" : 119,
  "siegeWeapon" : true,
  "flying" : false
}