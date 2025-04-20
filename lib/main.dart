import 'package:flutter/material.dart';
import 'package:flutter_example_flavor/flavor_config.dart';

void main() async {
  // Garante que o Flutter esteja completamente inicializado
  WidgetsFlutterBinding.ensureInitialized();

  // Inicializa a configuração do flavor (chama o nativo e define cor/nome)
  await FlavorConfig.instance.init();

  // Inicia o app
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      // Usando o nome do flavor como título da aplicação
      title: "App ${FlavorConfig.instance.flavor.name}",
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        alignment: Alignment.center,
        children: [FlavorBackGround(), FlavorText()],
      ),
    );
  }
}

class FlavorBackGround extends StatelessWidget {
  const FlavorBackGround({super.key});

  @override
  Widget build(BuildContext context) {
    /// Usando a cor do flavor como cor de fundo
    return Container(color: FlavorConfig.instance.flavor.color);
  }
}

class FlavorText extends StatelessWidget {
  const FlavorText({super.key});

  @override
  Widget build(BuildContext context) {
    /// Usando o nome do flavor como texto
    return Text(
      FlavorConfig.instance.flavor.name,
      style: const TextStyle(fontSize: 40, color: Colors.white),
    );
  }
}
