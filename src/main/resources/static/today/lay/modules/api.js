layui.define([],function(exports){
    console.log("============api.js============");
    exports('api',{
        getMenus: 'menu/' + currentUser.username + '?invalid_ie_cache=' + new Date().getTime()
    });
});