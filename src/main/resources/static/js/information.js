
(function($) {
    "use strict";
     $(document).on('ready', function() {
        $('.M-box4').pagination({
            pageCount: 50,
            jump: true,
            callback: function (api) {
                var data = {
                    page: api.getCurrent(),
                    name: 'mss',
                    say: 'oh'
                };
                console.log(api.getCurrent())
            }
        });
     })
})(jQuery);