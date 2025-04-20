package com.example.flutter_example_flavor // Nome do pacote (ajuste conforme seu projeto)

import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    val flavor = BuildConfig.FLAVOR_NAME // Obtém o nome do flavor definido no build.gradle
    private val channelName = "com.example.flutter_example_flavor/channel" // Nome do canal para comunicação Flutter <-> Android

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        // Cria o canal de comunicação com o Flutter
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, channelName).setMethodCallHandler {
            call, result ->
            if (call.method == "getFlavor") { // Se o Flutter solicitar o flavor
                result.success(flavor) // Retorna o flavor atual
            } else {
                result.notImplemented() // Método não implementado
            }
        }
    }
}
