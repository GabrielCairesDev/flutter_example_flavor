import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class FlavorConfigModel {
  final String name;
  final Color color;

  const FlavorConfigModel({required this.name, required this.color});
}

class FlavorConfig {
  static final FlavorConfig instance = FlavorConfig._internal();
  factory FlavorConfig() => instance;
  FlavorConfig._internal();

  static const MethodChannel _channel = MethodChannel(
    'com.example.flutter_example_flavor/channel',
  );

  FlavorConfigModel? _flavor;
  FlavorConfigModel get flavor => _flavor!;

  Future<void> init() async {
    final flavorName = await _channel.invokeMethod<String>('getFlavor');
    _flavor = _mapFlavor(flavorName ?? 'Desconhecido');
  }

  FlavorConfigModel _mapFlavor(String flavorName) {
    switch (flavorName) {
      case 'abacaxi':
        return FlavorConfigModel(
          name: 'Abacaxi',
          color: Colors.yellow.shade700,
        );
      case 'laranja':
        return FlavorConfigModel(name: 'Laranja', color: Colors.orange);
      case 'morango':
        return FlavorConfigModel(name: 'Morango', color: Colors.redAccent);
      default:
        return FlavorConfigModel(name: 'Desconhecido', color: Colors.grey);
    }
  }
}
