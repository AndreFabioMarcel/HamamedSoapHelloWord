(function(angular, $) {
    angular.module('notyModule', [])
        .provider('noty', function() {

            var settings = $.noty.defaults;

            return {
                settings: settings,
                $get: function() {
                    var callNoty = function(newSettings) {
                        return noty(newSettings || {});
                    };

                    return {
                        show: function(message, type) {
                            callNoty({
                                text: '<strong>Erro!</strong><br>' + message + '</p>' || settings.text,
                                type: type || settings.type,
                                layout: 'topRight',
                                dismissQueue: true,
                                timeout: 6000,                                
                                animation: {
                                    open: 'animated flipInX',
                                    close: 'animated flipOutX'
                                }
                            });
                        },

                        showAlert: function(message) {
                            callNoty({
                                text: message || settings.text,
                                type: "alert"
                            });
                        },

                        showSuccess: function(message) {
                            callNoty({
                                text: message || settings.text,
                                type: "success"
                            });
                        },

                        showError: function(message) {
                            callNoty({
                                text: message,
                                type: "error"
                            });
                        },

                        closeAll: function() {
                            return $.noty.closeAll()
                        },
                        clearShowQueue: function() {
                            return $.noty.clearQueue();
                        }.bind(this)
                    }
                }

            };
        })
}(angular, jQuery));
