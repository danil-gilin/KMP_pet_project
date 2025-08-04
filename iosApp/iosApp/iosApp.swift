//
//  iosAppApp.swift
//  iosApp
//
//  Created by Даниил Гилин on 24.07.2025.
//

import SwiftUI
import shared

@main
struct iosApp: App {

    init(){
        IosKoin.shared.initialize(userDefaults: UserDefaults.standard)
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
