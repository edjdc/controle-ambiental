#!/usr/bin/env bash
set -euo pipefail

REPO_ROOT="$(cd "$(dirname "$0")/../.." && pwd)"
cd "$REPO_ROOT"

declare -a banned_patterns=(
  "spring-security-oauth2-autoconfigure"
  "spring-cloud-starter-netflix-zuul"
  "spring-cloud-starter-netflix-hystrix"
  "spring-cloud-starter-oauth2"
  "springfox-swagger2"
  "springfox-swagger-ui"
)

poms="$(git ls-files '*pom.xml' | rg -v '/target/')"

failed=0
for pattern in "${banned_patterns[@]}"; do
  if rg -n --fixed-strings "$pattern" $poms >/dev/null 2>&1; then
    echo "Blocked unmaintained dependency detected: $pattern"
    rg -n --fixed-strings "$pattern" $poms
    failed=1
  fi
done

if [[ "$failed" -ne 0 ]]; then
  echo "Unmaintained dependency policy check failed."
  exit 1
fi

echo "Unmaintained dependency policy check passed."
