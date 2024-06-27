FROM antonkazakov/otus

ENV ANDROID_SDK_TOOLS 9477386
ENV ANDROID_BUILD_TOOLS_VERSION 33.0.0
ENV ANDROID_VERSION 33

ENV ANDROID_SDK_ROOT "/android_sdk"
ENV GRADLE_PROFILER_ROOT "/gradle_profiler"

ENV ANDROID_SDK_URL "https://dl.google.com/android/repository/commandlinetools-linux-${ANDROID_SDK_TOOLS}_latest.zip"
ENV GRADLE_PROFILER_URL "https://github.com/gradle/gradle-profiler/archive/refs/tags/v0.20.0.zip"

ENV PATH $PATH:$ANDROID_SDK_ROOT/tools:$ANDROID_SDK_ROOT/tools/bin:$ANDROID_SDK_ROOT/platform-tools:$ANDROID_SDK_ROOT/cmdline-tools/bin

RUN apt-get update && \
    apt-get install -y --no-install-recommends unzip curl wget && \
    # Android SDK
    mkdir "$ANDROID_SDK_ROOT" .android && \
    cd "$ANDROID_SDK_ROOT" && \
    curl -o sdk.zip $ANDROID_SDK_URL && \
    unzip sdk.zip && \
    rm sdk.zip && \
    yes | sdkmanager --licenses --sdk_root=$ANDROID_SDK_ROOT && \
    sdkmanager --update --sdk_root=$ANDROID_SDK_ROOT && \
    sdkmanager --sdk_root=$ANDROID_SDK_ROOT "build-tools;${ANDROID_BUILD_TOOLS_VERSION}" \
        "platforms;android-${ANDROID_VERSION}" \
        "platform-tools" \
        "extras;android;m2repository" \
        "extras;google;m2repository" && \
    # Gradle profiler
    mkdir "$GRADLE_PROFILER_ROOT" && \
    cd "$GRADLE_PROFILER_ROOT" && \
    wget -O gradle_profiler.zip $GRADLE_PROFILER_URL && \
    unzip gradle_profiler.zip && \
    rm gradle_profiler.zip && \
    # Clean up
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/* && \
    apt-get autoremove -y && \
    apt-get clean

RUN chown -R jenkins $ANDROID_SDK_ROOT
RUN chown -R jenkins $GRADLE_PROFILER_ROOT
USER jenkins