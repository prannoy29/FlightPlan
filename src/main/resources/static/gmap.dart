import 'package:google_maps/google_maps.dart';
import 'package:polymer/polymer.dart';

@CustomTag('gmap-map')
class MapElement extends PolymerElement {
  GMap map;

  MapElement.created() : super.created() {
    final mapOptions = new MapOptions()
      ..mapTypeId = MapTypeId.ROADMAP;
    final mapView = getShadowRoot('gmap-map').querySelector("#mapView");
    map = new GMap(mapView, mapOptions);
  }

  attached() {
    super.attached();

    // this allow to notify the map that the size of the canvas has changed.
    // in some cases, the map behaves like it has a 0*0 size.
    event.trigger(map, 'resize', []);
  }
}