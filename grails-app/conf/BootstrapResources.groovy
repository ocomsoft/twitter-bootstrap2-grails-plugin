def log = org.slf4j.LoggerFactory.getLogger('grails.plugins.twitterbootstrap2.BootstrapResources')
def dev = grails.util.GrailsUtil.isDevelopmentEnv()

def pluginManager = grails.util.Holders.pluginManager
def lesscssPlugin = pluginManager.getGrailsPlugin('lesscss-resources') || pluginManager.getGrailsPlugin('less-resources')
def jqueryPlugin = pluginManager.getGrailsPlugin('jquery')
def configTagLib = grails.util.Holders.config.grails.plugins.twitterbootstrap2.fixtaglib
def configDefaultBundle = grails.util.Holders.config.grails.plugins.twitterbootstrap2.defaultBundle
if (!configDefaultBundle && !configDefaultBundle.equals(false)) {
    configDefaultBundle = 'bundle_bootstrap2'
}

def dirLessSource
def dirTarget 

log.debug "dirLessSource: ${dirLessSource}"
log.debug "dirTarget: ${dirTarget}"

def cssFile = "bootstrap2.css"
def cssminFile = "bootstrap2.min.css"

log.debug "config: grails.plugins.twitterbootstrap2.fixtaglib = ${configTagLib}"
log.debug "config: grails.plugins.twitterbootstrap2.defaultBundle = ${configDefaultBundle}"

log.debug "is lesscss-resources plugin loaded? ${!!lesscssPlugin}"
log.debug "is jquery plugin loaded? ${!!jqueryPlugin}"

modules = {

    'bootstrap2-fixtaglib' {
        defaultBundle 'fixtaglib2'
        
        resource id: 'bootstrap2-fixtaglib', url:[plugin: 'twitter-bootstrap2', dir: 'css', file: 'bootstrap-fixtaglib.css'], disposition: 'head'
    }

    'bootstrap2-css' {
        defaultBundle configDefaultBundle
        if (configTagLib) {
            dependsOn 'bootstrap2-fixtaglib'
        }
        
        resource id: 'bootstrap2-css', url:[plugin: 'twitter-bootstrap2', dir: 'css', file: (dev ? cssFile : cssminFile)], disposition: 'head', exclude:'minify'
    }

    'bootstrap2-responsive-css' {
        defaultBundle configDefaultBundle
        dependsOn 'bootstrap2-css'

        resource id: 'bootstrap2-responsive-css', url:[plugin: 'twitter-bootstrap2', dir: 'css', file: (dev ? 'bootstrap2-responsive.css' : 'bootstrap2-responsive.min.css')], disposition: 'head', exclude:'minify'
    }
    
    'bootstrap2-responsive-less' {
		dependsOn 'bootstrap2-less'
		resource id: 'bootstrap2-responsive-less', url:[plugin: 'twitter-bootstrap2', dir: 'less', file: 'responsive.less'], attrs:[rel: "stylesheet/less", type:'css']
    }


    'bootstrap2-alert' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }

        resource id: 'bootstrap2-alert', url:[plugin: 'twitter-bootstrap2', dir: 'js', file: 'bootstrap-alert.js']
    }

    'bootstrap2-affix' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }

        resource id: 'bootstrap2-affix', url:[plugin: 'twitter-bootstrap2', dir: 'js', file: 'bootstrap-affix.js']
    }

    'bootstrap2-dropdown' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }

        resource id: 'bootstrap2-dropdown', url:[plugin: 'twitter-bootstrap2', dir: 'js', file: 'bootstrap-dropdown.js']
    }

    'bootstrap2-modal' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }
        
        resource id: 'bootstrap2-modal', url:[plugin: 'twitter-bootstrap2', dir: 'js', file: 'bootstrap-modal.js']
    }

    'bootstrap2-popover' {
        defaultBundle configDefaultBundle
        dependsOn 'bootstrap2-tooltip'
        
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }

        resource id: 'bootstrap2-popover', url:[plugin: 'twitter-bootstrap2', dir: 'js', file: 'bootstrap-popover.js']
    }

    'bootstrap2-scrollspy' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }
        
        resource id: 'bootstrap2-scrollspy', url:[plugin: 'twitter-bootstrap2', dir: 'js', file: 'bootstrap-scrollspy.js']
    }

    'bootstrap2-tab' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }
        
        resource id: 'bootstrap2-tab', url:[plugin: 'twitter-bootstrap2', dir: 'js', file: 'bootstrap-tab.js']
    }

    'bootstrap2-tooltip' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }
        
        resource id: 'bootstrap2-tooltip', url:[plugin: 'twitter-bootstrap2', dir: 'js', file: 'bootstrap-tooltip.js']
    }

    'bootstrap2-button' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }
        
        resource id: 'bootstrap2-button', url:[plugin: 'twitter-bootstrap2', dir: 'js', file: 'bootstrap-button.js']
    }

    'bootstrap2-carousel' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }

        resource id: 'bootstrap2-carousel', url:[plugin: 'twitter-bootstrap2', dir: 'js', file: 'bootstrap-carousel.js']
    }

    'bootstrap2-typeahead' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }

        resource id: 'bootstrap2-typeahead', url:[plugin: 'twitter-bootstrap2', dir: 'js', file: 'bootstrap-typeahead.js']
    }

    'bootstrap2-collapse' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }

        resource id: 'bootstrap2-collapse', url:[plugin: 'twitter-bootstrap2', dir: 'js', file: 'bootstrap-collapse.js']
    }

    'bootstrap2-transition' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn "jquery"
        }

        resource id: 'bootstrap2-transition', url:[plugin: 'twitter-bootstrap2', dir: 'js', file: 'bootstrap-transition.js']
    }

    'bootstrap2-js' {
        defaultBundle configDefaultBundle
        if (jqueryPlugin) {
            dependsOn 'jquery'
        }
        dependsOn 'bootstrap2-transition,bootstrap2-alert,bootstrap2-dropdown,bootstrap2-modal,bootstrap2-scrollspy,bootstrap2-tab,bootstrap2-tooltip,bootstrap2-popover,bootstrap2-button,bootstrap2-carousel,bootstrap2-typeahead,bootstrap2-collapse,bootstrap2-affix'
    }

    'bootstrap2-less' {
        defaultBundle configDefaultBundle
        if (configTagLib) {
            dependsOn 'bootstrap2-fixtaglib'
        }
        
        resource id:'bootstrap2-less', url:[plugin: 'twitter-bootstrap2', dir: 'less', file: 'bootstrap.less'], attrs:[rel: "stylesheet/less", type:'css', order:100], disposition: 'head'
    }

    bootstrap2 {
        defaultBundle configDefaultBundle
        if (lesscssPlugin) {
            dependsOn 'bootstrap2-less'
        } else {
            dependsOn 'bootstrap2-css'
        }
        dependsOn 'bootstrap2-js'
    }
       
}
