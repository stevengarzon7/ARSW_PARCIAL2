let app = (() => {
    let client = apiclient;

    var mapObjetos = (funciones) => {
        listaFunciones = funciones.map(({name, humidity, visibility, temperature}) => ({
                name: name,
                humidity: humidity,
                visibility: visibility,
                temperature: temperature
            })
        )
        $("#tabla > tbody").empty();
        listaFunciones.forEach(({name, humidity, visibility, temperature}) => {
            $("#tabla > tbody").append(
                `<tr>
            <td><a onclick="app.consultarPais('${name}')">${name}</a> </td>   
            <td> ${humidity} </td>
            <td> ${visibility} </td>
            <td> ${temperature} </td>
        </tr>`
            );
        });
    }
    var mapPaises = (funciones) => {
        listaPaises = funciones.provinces;
        plotMarkers(funciones.location);
        $("#tablaPais > tbody").empty();
        // const p = listaFunciones.map(a => a.provinces.valueOf())
        // console.log(p)
        listaPaises.forEach((province) => {
            $("#tablaPais > tbody").append(
                `<tr>
            <td> ${province.name} </td>   
            <td> ${province.visibility} </td>
            <td> ${province.humidity} </td>
            <td> ${province.temperature} </td>
        </tr>`
            );
        });
    }
    var initMap = () => {
        map = new google.maps.Map(document.getElementById("map"), {
            zoom: 2,
            center: {lat: 35.717, lng: 139.731},
        });
    }

    function plotMarkers(m) {
        console.log(m)
        markers = [];
        bounds = new google.maps.LatLngBounds();
        console.log(m.latitude, m.longitude);
        var position = new google.maps.LatLng(m.latitude, m.longitude);
        console.log(position);
        markers.push(
            new google.maps.Marker({
                position: position,
                map: map,
                animation: google.maps.Animation.DROP
            })
        );
        bounds.extend(position);
        map.fitBounds(bounds);
        map.setZoom(4);
    }

    function init() {
        initMap();
        client.getAllWeathers(mapObjetos);
    }

    return {
        init: init,
        consultarPais(nombre) {
            console.log(nombre)
            client.getWeatherByCountry(nombre, mapPaises);
        }
    }
})();
