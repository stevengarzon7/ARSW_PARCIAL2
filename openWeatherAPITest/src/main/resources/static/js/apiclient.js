apiclient = (function () {
    let url = "http://localhost:8080/v1/";
    return {
        getAllWeathers: function (callback) {
            $.getJSON(url, (data) => {
                callback(data);
            }, null)
        },
        getWeatherByCountry: function (country, callback) {
            $.getJSON(url + "weather/?country=" + country, (data) => {
                callback(data);
            }, null)
        },

    }

})();
