#!/usr/bin/env bash
# Resolves the library version from a release tag: "v1.0.83" and "1.0.83" both become "1.0.83".
set -euo pipefail
tag="${1:?usage: resolve-version.sh <tag>}"
echo "VERSION=${tag#v}" >> "$GITHUB_ENV"
