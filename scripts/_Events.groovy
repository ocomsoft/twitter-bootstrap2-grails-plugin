eventAssetPrecompileStart = { assetConfig ->
	if(!config.grails.assets.plugin."twitter-bootstrap2".excludes || config.grails.assets.plugin."twitter-bootstrap2".excludes.size() == 0) {
		config.grails.assets.plugin."twitter-bootstrap2".excludes = ["**/*.less"]
	}
}
