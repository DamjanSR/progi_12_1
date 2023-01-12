import React from "react";
import Navbar from "./NavBar";
import {
  GoogleMap,
  useJsApiLoader,
} from "@react-google-maps/api";

import { containerStyle, center, options } from "../mapSetting";



  


const NewMap: React.FC = () => {
  const { isLoaded } = useJsApiLoader({
    id: "google-map-script",
    googleMapsApiKey: "AIzaSyDeHh4O3P2hY0IaDdiBQ3siTDi9O3prDQo",
  });

  const mapref = React.useRef<google.maps.Map | null>(null);

  const onLoad = (map: google.maps.Map): void => {
    mapref.current = map;
  };

  const onUnMount = (): void => {
    mapref.current = null;

  };

  if (!isLoaded) return <div>Map Loading ...</div>;
  return (
    <>
      <GoogleMap
        mapContainerStyle={containerStyle}
        options={options as google.maps.MapOptions}
        center={center}
        zoom={14}
        onLoad={onLoad}
        onUnmount={onUnMount}
      ></GoogleMap>

    </>
  );
};

export default NewMap;
